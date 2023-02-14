public class Withdraw extends Usage{

    private boolean status;

    public Withdraw(double amount, Account acc){
        super(amount);
        this.status = acc.withdrawBalance(amount, this);
    }


    @Override
    public String toString(){
        String amount = "Amount: " + String.format("%.2f %s", getAmount(), Main.currency);
        String date = "\nDate: " + getDate();
        String opStatus = this.status ? "Successful": "Failed"; 
        opStatus = "\nWithdraw Status: " + opStatus + "\n";
        return amount + date + opStatus;
    }
    
}
