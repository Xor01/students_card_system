import java.util.ArrayList;

/**
 * SCS
 */
public class SCS {

    private String barcode;
    private Account account;
    private boolean cardStatus;
    private ArrayList <Fee> fee;
    private ArrayList <Deposit> deposit;
    private ArrayList <Access> access;
    private ArrayList <Withdraw> withdraw;

    public SCS(String barcode){
        fee = new ArrayList<>();
        account = new Account();
        deposit = new ArrayList<>();
        access = new ArrayList<>();
        withdraw = new ArrayList<>();
        this.barcode = "KFU" + barcode + "CODE";
        this.cardStatus = true;
    }

    public void addFee(String name, double amount){
        if (!cardStatus) {System.out.println("Sorry, You are unable to process."); return;}
        fee.add(new Fee(name, amount));
        System.out.println("Fee Has Been Added.");
    }

    public void listFees(){
        for (Fee f : fee) {
            System.out.println(f);
            System.out.println("-----------------------");
        }
    }

    public void addAccess(String name){
        if (!cardStatus) {System.out.println("Sorry, You are unable to process."); return;}
        access.add(new Access(name));
    }
    
    public void listAccesses(){
        for (Access a : access) {
            System.out.println(a);
            System.out.println("-----------------------");
        }
    }
    
    public void addDeposit(double amount){
        if (!cardStatus) {System.out.println("Sorry, You are unable to process."); return;}
        
        if (amount > 0) {
            deposit.add(new Deposit(amount,this.account));
        }
        else
            System.out.println("You Only Can Deposit Amount Greater Than Zero.");
    }

    public void listDeposits(){
        if (deposit.isEmpty()) {
            System.out.println("No Deposits Occurred In Your Account");
            return;
        }

        for (Deposit dep : deposit) {
            System.out.println(dep);
            System.out.println("-------------------------");
        }
    }
    public void addWithdraw(double amount){
        if (!cardStatus) {System.out.println("Sorry, You are unable to process."); return;}

        if (amount > 0) {
            withdraw.add(new Withdraw(amount, this.account));
        }
        else
            System.out.println("You Only Can Withdraw Amount Greater Than Zero.");
    }

    public void listWithdraws(){
        
        if (withdraw.isEmpty()) {
            System.out.println("No Deposits Occurred In Your Account");
            return;
        }
        for (Withdraw draw : withdraw) {
            System.out.print(draw);
            System.out.println("-------------------------");
        }
    }

    public double getBalance(){
        return account.getBalance();
    }
    public String getBarcode(){
        if (!cardStatus) {System.out.println("Sorry, You are unable to process.");return "";}
        return this.barcode;
    }
    
    public void deActivateCard(){
        this.cardStatus = false;
    }

    public void activateCard(){
        this.cardStatus = true;
    }

    public boolean getCardStatus(){
        return this.cardStatus;
    }
}