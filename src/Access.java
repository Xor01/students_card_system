public class Access extends Usage{


    public Access(String name) {
        super(name);
        
    }

    public String toString(){
        
        String name = "Access Place Name: " + this.getName();
        String date = "\nAccess Date: " + this.getDate();

        return name + date;
    }
    
}
