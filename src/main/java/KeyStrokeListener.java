import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.*;
import scene.Root;

import java.util.concurrent.atomic.AtomicBoolean;

public class KeyStrokeListener /*implements WindowListener*/ {

    /*public void onInput(Window basePane, KeyStroke keyStroke, AtomicBoolean deliverEvent) {

        if(keyStroke.getCharacter()!=null) {

            if (keyStroke.isAltDown() & keyStroke.getCharacter() == 's') {
                Root.text = Root.textPanel.getText();
                Root.clearSurface();
                Root.saveFileScene();
                //Main.textGUI.removeWindow(Main.window);
            }

            if (keyStroke.isAltDown() & keyStroke.getCharacter() == 'r') {
                Root.clearSurface();
                Root.editFileScene();
                //Main.textGUI.removeWindow(Main.window);
            }

        }

        Main.window.setPosition(new TerminalPosition(10,10));
        Main.window.setSize(new TerminalSize(10,10));
        Main.textPanel.setSize(new TerminalSize(100,100));



    }

    public void onUnhandledInput(Window basePane, KeyStroke keyStroke, AtomicBoolean hasBeenHandled) {

    }

    public void onResized(Window window, TerminalSize oldSize, TerminalSize newSize) {
        System.out.println(Main.screen.getTerminalSize()+" "+Main.window.getSize());
        if(!Main.window.getSize().equals(Main.screen.getTerminalSize())) {
            Main.window.setSize(Main.screen.getTerminalSize());
            Main.contentPanel.setLayoutManager(new GridLayout());
        }
    }

    public void onMoved(Window window, TerminalPosition oldPosition, TerminalPosition newPosition) {

    }*/

}
