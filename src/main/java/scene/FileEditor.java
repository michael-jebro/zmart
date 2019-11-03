package scene;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class FileEditor implements WindowListener {

    //SCENE CONTENT
    private Window window;
    private Panel contentPanel;
    private Label label;
    private TextBox textPanel;
    public static String text = "";

    //SELF OBJECT
    public static FileEditor self = new FileEditor();

    FileEditor(){

        //Init Scene Content
        this.window = new BasicWindow("New file");
        this.contentPanel = new Panel(new GridLayout(50));
        this.label = new Label("Write text here:");
        this.textPanel = new TextBox(new TerminalSize(50,20));

    }

    //IMPLEMENTED FUNCTIONS
    public void onInput(Window basePane, KeyStroke keyStroke, AtomicBoolean deliverEvent) {

        if(keyStroke.getCharacter()!=null) {
            if (keyStroke.isAltDown() & keyStroke.getCharacter() == 's') {
                text = textPanel.getText();
                this.hide();
                FileSaver.self.show();
            }
        }

    }

    public void onUnhandledInput(Window basePane, KeyStroke keyStroke, AtomicBoolean hasBeenHandled) {}

    public void onResized(Window window, TerminalSize oldSize, TerminalSize newSize) {}

    public void onMoved(Window window, TerminalPosition oldPosition, TerminalPosition newPosition) {}

    //NATIVE FUNCTIONS
    public void show(){

        //Behaviour
        this.window.addWindowListener(self);

        //Surface
        textPanel.setText(text);
        contentPanel.addComponent(label);
        contentPanel.addComponent(textPanel);
        window.setComponent(contentPanel);
        Root.textGUI.addWindowAndWait(window);

    }

    public void hide(){
        Root.textGUI.removeWindow(window);
    }
}
