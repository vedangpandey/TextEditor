import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePad implements ActionListener {

    //Menu Bar and ScrollBar/////////////////////////////////////
    private JMenuBar menuBar;
    JScrollBar scrollBar;
    boolean wordWrapOn=false;
    //Frame///////////////////////////////////////////////////////
     JFrame frame;
    //-----------------------------------Text-Area-------------------------------//
     JTextArea textArea;
    private JScrollPane scrollPane;

    //--------------------------------------Menu----------------------------------//
     JMenu fileMenu;
     JMenu editMenu;
     JMenu formatMenu;
     JMenu colorMenu;
    //------------------------------------MenuItem-For-File---------------------------------//
     JMenuItem New,Save,Open,SaveAs,Exit;
    //------------------------------------MenuItem-For-Format---------------------------------//
     JMenu font,fontSize;
     JMenuItem wordWrap, iFontArial, iFontCMS, iFontTNR,iFontSize8,iFontSize10,iFontSize12,iFontSize14,iFontSize16,iFontSize18,iFontSize20,iFontSize22,iFontSize24,iFontSize28;

     //--------------------------------------------Menu-Item-For-Color----------------------------------//
    JMenuItem iColor1,iColor2,iColor3,iColor4;
    //---------------------------------------------Menu-Item-For-Edit-------------------------------//
    JMenuItem iUndo,iRedo;

     Funciton_File file=new Funciton_File(this);
     Function_Format funtionFormat=new Function_Format(this);
     Function_Color functionColor=new Function_Color(this);
     Function_Edit functionEdit=new Function_Edit(this);
     KeyHandler keyHandler=new KeyHandler(this);
     UndoManager um=new UndoManager();
        public NotePad(){
            createFrame();
            createTextArea();
            createMenuBar();
            createFileMenu();
            createFormatMenu();
            createColorMenu();
            createEditMenu();
            funtionFormat.selectedFont="Arial";
            funtionFormat.createFont(14);
            funtionFormat.wordWrap();
            functionColor.changeColor("white");
            frame.setVisible(true);

        }
        public void createFrame(){
            frame=new JFrame("Notepad");
            frame.setSize(800,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        public void createTextArea(){
            textArea=new JTextArea();
            textArea.addKeyListener(keyHandler);
            textArea.getDocument().addUndoableEditListener(
                    new UndoableEditListener() {
                        @Override
                        public void undoableEditHappened(UndoableEditEvent e) {
                            um.addEdit(e.getEdit());
                        }
                    }
            );
            scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            frame.add(scrollPane);
//            frame.add(textArea);
        }
        public void createMenuBar(){
            menuBar=new JMenuBar();
            fileMenu=new JMenu("File");
            editMenu=new JMenu("Edit");
            formatMenu=new JMenu("Format");
            colorMenu=new JMenu("Color");
            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(formatMenu);
            menuBar.add(colorMenu);
            frame.setJMenuBar(menuBar);

        }
        public void createFileMenu(){

            //new Functionality
            New=new JMenuItem("New");
            New.setActionCommand("New");
            New.addActionListener(this);

            //Open Functionality
            Open=new JMenuItem("Open");
            Open.setActionCommand("Open");
            Open.addActionListener(this);

            //Save Functionality
            Save=new JMenuItem("Save");
            Save.setActionCommand("Save");
            Save.addActionListener(this);
            SaveAs=new JMenuItem("Save as");
            SaveAs.setActionCommand("Save as");
            SaveAs.addActionListener(this);

            Exit=new JMenuItem("Exit");
            Exit.addActionListener(this);
            Exit.setActionCommand("Exit");

            fileMenu.add(New);
            fileMenu.add(Open);
            fileMenu.add(Save);
            fileMenu.add(SaveAs);
            fileMenu.add(Exit);
        }
        public void createEditMenu(){
            iUndo=new JMenuItem("Undo");
            iUndo.setActionCommand("Undo");
            iUndo.addActionListener(this);
            iRedo=new JMenuItem("Redo");
            iRedo.setActionCommand("Redo");
            iRedo.addActionListener(this);

            editMenu.add(iUndo);
            editMenu.add(iRedo);
        }
        public void createFormatMenu() {
            wordWrap=new JMenuItem("WordWrap: off");
            wordWrap.addActionListener(this);
            wordWrap.setActionCommand("WordWrap");

            font=new JMenu("Font");
            fontSize=new JMenu("FontSize");

            iFontArial=new JMenuItem("Arial");
            iFontArial.setActionCommand("Arial");
            iFontArial.addActionListener(this);


            iFontCMS=new JMenuItem("Comic Sans MS");
            iFontCMS.setActionCommand("Comic Sans MS");
            iFontCMS.addActionListener(this);


            iFontTNR=new JMenuItem("Times New Roman");
            iFontTNR.setActionCommand("Times New Roman");
            iFontTNR.addActionListener(this);

            font.add(iFontArial);
            font.add(iFontCMS);
            font.add(iFontTNR);

            iFontSize8=new JMenuItem("8");
            iFontSize8.setActionCommand("size8");
            iFontSize8.addActionListener(this);

            iFontSize10=new JMenuItem("10");
            iFontSize10.setActionCommand("size10");
            iFontSize10.addActionListener(this);

            iFontSize12=new JMenuItem("12");
            iFontSize12.setActionCommand("size12");
            iFontSize12.addActionListener(this);


            iFontSize14=new JMenuItem("14");
            iFontSize14.setActionCommand("size14");
            iFontSize14.addActionListener(this);


            iFontSize16=new JMenuItem("16");
            iFontSize16.setActionCommand("size16");
            iFontSize16.addActionListener(this);

            iFontSize18=new JMenuItem("18");
            iFontSize18.setActionCommand("size18");
            iFontSize18.addActionListener(this);

            iFontSize20=new JMenuItem("20");
            iFontSize20.setActionCommand("size20");
            iFontSize20.addActionListener(this);

            iFontSize22=new JMenuItem("22");
            iFontSize22.setActionCommand("size22");
            iFontSize22.addActionListener(this);

            iFontSize24=new JMenuItem("24");
            iFontSize24.setActionCommand("size24");
            iFontSize24.addActionListener(this);

            iFontSize28=new JMenuItem("28");
            iFontSize28.setActionCommand("size28");
            iFontSize28.addActionListener(this);

            fontSize.add(iFontSize8);
            fontSize.add(iFontSize10);
            fontSize.add(iFontSize12);
            fontSize.add(iFontSize14);
            fontSize.add(iFontSize16);
            fontSize.add(iFontSize18);
            fontSize.add(iFontSize20);
            fontSize.add(iFontSize22);
            fontSize.add(iFontSize24);
            fontSize.add(iFontSize28);

            formatMenu.add(wordWrap);
            formatMenu.add(font);
            formatMenu.add(fontSize);

        }
        public void createColorMenu(){
            iColor1=new JMenuItem("White");
            iColor1.setActionCommand("white");
            iColor1.addActionListener(this);
            iColor2=new JMenuItem("Blue");
            iColor2.setActionCommand("blue");
            iColor2.addActionListener(this);
            iColor3=new JMenuItem("Green");
            iColor3.addActionListener(this);
            iColor3.setActionCommand("green");
            iColor4=new JMenuItem("Red");
            iColor4.addActionListener(this);
            iColor4.setActionCommand("red");
            colorMenu.add(iColor1);
            colorMenu.add(iColor2);
            colorMenu.add(iColor3);
            colorMenu.add(iColor4);
        }

    public static void main(String[] args) {
        new NotePad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String st=e.getActionCommand();
        switch(st){
            case "New":file.newFile();break;
            case "Open":file.open();break;
            case "Save as":file.saveas();break;
            case "Save":file.save();break;
            case "Exit":file.exit();break;
            case "WordWrap":funtionFormat.wordWrap();break;
            case "size8":funtionFormat.createFont(8);break;
            case "size10":funtionFormat.createFont(10);break;
            case "size12":funtionFormat.createFont(12);break;
            case "size14":funtionFormat.createFont(14);break;
            case "size16":funtionFormat.createFont(16);break;
            case "size20":funtionFormat.createFont(20);break;
            case "size22":funtionFormat.createFont(22);break;
            case "size24":funtionFormat.createFont(24);break;
            case "size28":funtionFormat.createFont(28);break;
            case "Arial":funtionFormat.setFont(st);break;
            case "Times New Roman":funtionFormat.setFont(st);break;
            case "Comic Sans MS":funtionFormat.setFont(st);break;
            case "white":functionColor.changeColor(st);break;
            case "red":functionColor.changeColor(st);break;
            case "blue":functionColor.changeColor(st);break;
            case "green":functionColor.changeColor(st);break;
            case "Undo": functionEdit.undo();    break;
            case "Redo":functionEdit.redo();
        }
    }
}
