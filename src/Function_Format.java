import java.awt.*;

public class Function_Format {
    NotePad note;
    Font arial,comicSansMS,timesNewRoman;
    String selectedFont;
    Function_Format(NotePad note){
        this.note=note;
    }
    public void wordWrap(){
        if(!note.wordWrapOn){
            note.wordWrapOn=true;
            note.textArea.setLineWrap(true);
            note.textArea.setWrapStyleWord(true);
            note.wordWrap.setText("WordWrap:On");
        }
        else if(note.wordWrapOn){
            note.wordWrapOn=false;
            note.textArea.setLineWrap(false);
            note.textArea.setWrapStyleWord(false);
            note.wordWrap.setText("WordWrap:Off");
        }
    }
    public void createFont(int fontSize){
        arial=new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontSize);
        timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);
        setFont(selectedFont);
    }
    public void setFont(String font){
        selectedFont=font;
        switch (selectedFont){
            case "Comic Sans MS": note.textArea.setFont(comicSansMS);break;
            case "Arial" : note.textArea.setFont(arial); break;
            case "Times New Roman":note.textArea.setFont(timesNewRoman);break;
        }
    }
}
