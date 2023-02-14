public class Fee extends Usage {

    public Fee(String name, double amount){
        super(name, amount);

    }

    public Fee addFee(String name, double amount){
        Fee fee = new Fee(name, amount);
        return fee;
    }

    public String toString(){
        String fee = "Fee Name: " + this.getName();
        String date = "\nFee Date: " + this.getDate();
        String amount = "\nFee Price: " + this.getAmount();
        return fee + date + amount;
    }
}
