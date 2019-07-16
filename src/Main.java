import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.bundle.*;
import com.googlecode.lanterna.graphics.*;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        Terminal terminal = null;
        Screen screen = null;

        try{
            terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

            final Window window = new BasicWindow("New tab");

            Panel contentPanel = new Panel(new GridLayout(50));

            //CONTENTS
            contentPanel.addComponent(new Label("Write text here:"));

            contentPanel.addComponent(
                    new TextBox(new TerminalSize(50,20))
                            .setLayoutData
                                    (GridLayout.createLayoutData
                                            (GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER)
                                    )
            );

            KeyStrokeListener listener = new KeyStrokeListener();
            window.addWindowListener(listener);

            window.setComponent(contentPanel);
            textGUI.addWindowAndWait(window);

            KeyStroke keyPressed = terminal.readInput();
            System.out.println("keyPressed: " + keyPressed.getKeyType());

        }catch(IOException io){

            io.printStackTrace();

        }finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                    terminal.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*try{

            terminal = defaultTerminalFactory.createTerminal();

            terminal.enterPrivateMode();

            KeyStroke keyStroke = terminal.readInput();
            StringBuilder a = new StringBuilder();

            while(true){
                keyStroke = terminal.readInput();

                if(keyStroke.getKeyType() == KeyType.Backspace){

                    terminal.putCharacter('\r');

                }else{

                    terminal.putCharacter(keyStroke.getCharacter());

                }
                terminal.flush();
            }

        }catch(IOException ioe) {

            ioe.printStackTrace();

        }finally {
            //----------------------------
            if(terminal != null) {
                try{
                    terminal.close();
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
            //----------------------------
        }*/
    }
}

/*class A{
    private Screen screen;
    private TextBox textBox;
    private final String emptyString = "";
    public String getText() throws IOException {
        String result = null;
        KeyStroke key = null;
        while ((key = screen.readInput()).getKeyType() != KeyType.Enter) {
            textBox.handleKeyStroke(key);
            // use only one of handleInput() or handleKeyStroke()
            textBox.setText(textBox.getText());
        }
        result = textBox.getText();
        textBox.setText(emptyString);
        return result;
    }
}*/
