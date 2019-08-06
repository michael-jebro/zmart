package scene;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.concurrent.atomic.AtomicBoolean;

public class FileSaver implements WindowListener {

    //SCENE CONTENT
    private Window window;
    private Panel contentPanel;
    private Label label;
    private TextBox textPanel;

    //SELF OBJECT
    public static FileSaver self = new FileSaver();

    FileSaver(){

        //Init Scene Content
        this.window = new BasicWindow("");
        this.contentPanel = new Panel(new GridLayout(50));
        this.label = new Label("Write file path here:");
        this.textPanel = new TextBox(new TerminalSize(30, 1));

    }

    //IMPLEMENTED FUNCTIONS
    public void onInput(Window basePane, KeyStroke keyStroke, AtomicBoolean deliverEvent) {

        if(keyStroke.getCharacter()!=null) {
            if (keyStroke.isAltDown() & keyStroke.getCharacter() == 'c') {
                this.hide();
                FileEditor.self.show();
            }
        }

    }

    public void onUnhandledInput(Window basePane, KeyStroke keyStroke, AtomicBoolean hasBeenHandled) {}

    public void onResized(Window window, TerminalSize oldSize, TerminalSize newSize) {}

    public void onMoved(Window window, TerminalPosition oldPosition, TerminalPosition newPosition) {}

    public void show(){

        //Behaviour
        window.addWindowListener(self);

        //Surface
        contentPanel.addComponent(label);
        contentPanel.addComponent(textPanel);
        window.setComponent(contentPanel);
        Root.textGUI.addWindowAndWait(window);

    }

    public void hide(){
        Root.textGUI.removeWindow(window);
    }
}
