import javax.swing.*;
import java.awt.*;
public class Function_Color {
    NotePad note;
    Function_Color(NotePad note){
        this.note=note;
    }
    public void changeColor(String Color){
        switch(Color){
            case "white":note.frame.getContentPane().setBackground(java.awt.Color.white);
            note.textArea.setBackground(java.awt.Color.white);
            note.textArea.setForeground(java.awt.Color.black);break;
            case "red":note.frame.getContentPane().setBackground(java.awt.Color.red);
                note.textArea.setBackground(java.awt.Color.red);
                note.textArea.setForeground(java.awt.Color.black);break;
            case "blue":note.frame.getContentPane().setBackground(new Color(28,186,186));
                note.textArea.setBackground(new Color(28,186,186));
                note.textArea.setForeground(java.awt.Color.yellow);break;
            case "green":note.frame.getContentPane().setBackground(java.awt.Color.green);
                note.textArea.setBackground(java.awt.Color.green);
                note.textArea.setForeground(java.awt.Color.black);break;
        }
    }
}
