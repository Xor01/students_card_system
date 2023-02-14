/**
 * Student
 */
public class Student {

    private String id;
    private String name;
    private String college;
    private String dep;
    private SCS scs;

    public Student(String name, String college, String dep, String id){
        this.name = name;
        this.college = college;
        this.dep = dep;
        this.id = id;
        this.scs = new SCS(id);
    }

    public String getId(){
        return this.id;
    }

    public void addFee(String name, double price){
        scs.addFee(name, price);
    }

    public void listFees(){
        scs.listFees();
    }

    public void addAccess(String name){
        scs.addAccess(name);
    }
    
    public void listAccess(){
        scs.listAccesses();
    }

    public void deposit(double amount){
        scs.addDeposit(amount);
    }

    public void listDeposit(){
        scs.listDeposits();
    }

    public double getBalance(){
        return scs.getBalance();
    }

    public void withdraw(double amount){
        scs.addWithdraw(amount);
    }

    public void listWithdraws(){
        scs.listWithdraws();
    }

    @Override
    public String toString(){
        String id  = "Student ID: " + this.id;
        String name = "\nStudent Name: " + this.name;
        String college = "\nStudent College: " + this.college;
        String dep = "\nStudent Department: " + this.dep;
        return id + name + college+ dep;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getDep() {
        return dep;
    }

    public String getBarcode() {
        return scs.getBarcode();
    }
    public boolean getCardStatus() {
        return scs.getCardStatus();
    }
    
    public void activateCard() {
        this.scs.activateCard();
    }

    public void deActivateCard(){
        this.scs.deActivateCard();
    }
    
}