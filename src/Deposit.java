public class Deposit extends Usage {

    private boolean status;

    public Deposit(double amount, Account acc) {
        super(amount);
        this.status = acc.depositBalance(amount, this);
    }

    @Override
    public String toString() {

        String amount = "Amount: " + String.format("%.2f %s", getAmount(), Main.currency);
        String date = "\nDate: " + getDate();

        String opStatus = this.status ? "Successful" : "Failed";
        opStatus = "\nDeposit Status: " + opStatus;
        return amount + date + opStatus;
    }

}
