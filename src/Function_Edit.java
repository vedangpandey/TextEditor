public class Function_Edit {
    NotePad note;
    Function_Edit(NotePad note){
        this.note=note;
    }
    public void undo(){
        try {
            note.um.undo();
        }catch(Exception ex){
            System.out.println("there is nothing to undo");
        }
    }
    public void redo(){
        try {
            note.um.redo();
        }catch (Exception ex){
            System.out.println("there is nothing to redo");
        }
    }
}
