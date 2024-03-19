import java.awt.*;
import java.io.*;

public class Funciton_File {
    NotePad notePad;
     String filename;
     String fileadress;
    public Funciton_File(NotePad notePad){
        this.notePad=notePad;
    }
    public void newFile(){
        notePad.textArea.setText("");
        notePad.frame.setTitle("New");
        filename=null;
        fileadress=null;
    }
    public void open(){
        FileDialog fd=new FileDialog(notePad.frame,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null) {
            filename = fd.getFile();
            System.out.println(filename);
            fileadress = fd.getDirectory();
            notePad.frame.setTitle(filename);
        }
        try{
            BufferedReader br=new BufferedReader(new FileReader(fileadress+filename));
            notePad.textArea.setText("");
            String line=null;
            while((line=br.readLine())!=null){
                notePad.textArea.append(line+"\n");
            }
            br.close();

        }catch (IOException ioe){
            System.out.println("File Not Found");
        }
    }

    public void saveas(){
        FileDialog fd=new FileDialog(notePad.frame,"SaveAs",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null){
             filename=fd.getFile();
             fileadress =fd.getDirectory();
             notePad.frame.setTitle(filename);
        }
        try{
            FileWriter fw=new FileWriter(fileadress+filename);
            fw.write(notePad.textArea.getText());
            fw.close();
        }catch(IOException io){
            System.out.println("CouldNot Save The file!!");
        }
    }
    public void save(){
        System.out.println(filename);
        if(filename==null){
            saveas();
        }
        else{
            try {
                FileWriter fw=new FileWriter(fileadress+filename);
                fw.write(notePad.textArea.getText());
                notePad.frame.setTitle(filename);
                fw.close();
            }catch (Exception io){
                System.out.println("There was an error");
            }
        }
    }
    public void exit(){
        System.exit(0);
    }
}
