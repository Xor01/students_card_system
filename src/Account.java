public class Account {

    private double balance = 0.0;

    public boolean depositBalance(double amount, Deposit dep) {

        if (dep != null) {
            this.balance += amount;
            System.out.println("Balance has been Added.");
            System.out.printf("New Balance: %.2f %s\n", this.balance, Main.currency);
            return true;
        } else
            System.out.println("Operation Could Not Process!");
        return false;
    }

    public boolean withdrawBalance(double amount, Withdraw wd) {

        if (wd != null && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Balance has been Withdrawn.");
            System.out.printf("New Balance: %.2f %s\n", this.balance, Main.currency);
            return true;
        } else
            System.out.println("Operation Could Not Process!");
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

}
