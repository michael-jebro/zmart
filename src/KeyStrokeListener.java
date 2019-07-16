import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.bundle.*;
import com.googlecode.lanterna.graphics.*;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class KeyStrokeListener implements WindowListener {
    public void onInput(Window basePane, KeyStroke keyStroke, AtomicBoolean deliverEvent) {
        System.out.println("Pressed: "+ keyStroke);
    }

    public void onUnhandledInput(Window basePane, KeyStroke keyStroke, AtomicBoolean hasBeenHandled) {
        // TODO Auto-generated method stub
    }

    public void onResized(Window window, TerminalSize oldSize, TerminalSize newSize) {
        // TODO Auto-generated method stub
    }

    public void onMoved(Window window, TerminalPosition oldPosition, TerminalPosition newPosition) {
        // TODO Auto-generated method stub
    }
}
