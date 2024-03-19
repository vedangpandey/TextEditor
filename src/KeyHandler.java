import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    NotePad note;
    public KeyHandler(NotePad note){
        this.note=note;
    }
    @Override
    public void keyTyped(KeyEvent e) {
            System.out.println("some key is pressed"+e.getKeyCode());
            if (e.isControlDown()&&e.getKeyCode() == KeyEvent.VK_S) {
                System.out.println("s is down");
                note.file.save();
            }
            else if (e.isControlDown()&&e.getKeyCode() == KeyEvent.VK_O)
                note.file.open();
            else if (e.isControlDown()&&e.getKeyCode() == KeyEvent.VK_Z)
                note.functionEdit.undo();
            else if (e.isControlDown()&&e.getKeyCode() == KeyEvent.VK_Y)
                note.functionEdit.redo();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
