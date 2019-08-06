package scene;

import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.*;

import java.io.IOException;

public class Root {

    //ROOT
    static Screen screen;
    static Terminal terminal;
    static WindowBasedTextGUI textGUI;

    public void startRoot(){

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        //===============================================================
        try{

            //Root INIT
            terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            textGUI = new MultiWindowTextGUI(screen);

            //Start scene
            FileEditor.self.show();


        }catch(IOException io){

            io.printStackTrace();

        }finally {

            if(screen != null) {
                //-----------------------
                try {

                    screen.stopScreen();
                    terminal.close();

                }catch(IOException e) {

                    e.printStackTrace();

                }
                //-----------------------
            }

        }
        //===============================================================

    }

}
