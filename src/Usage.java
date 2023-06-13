import java.util.Date;

public abstract class Usage {
    private String name = "Undefined";
    private final String date;
    private double amount = 0.00;

    public Usage(String name) {
        this.name = name;
        this.date = new Date().toString();
    }

    public Usage(double amount) {
        this.amount = amount;
        this.date = new Date().toString();
    }

    public Usage(String name, double amount) {
        this.name = name;
        this.amount = amount;
        this.date = new Date().toString();
    }

    protected String getName() {
        return name;
    }

    protected String getDate() {
        return date;
    }

    protected double getAmount() {
        return amount;
    }

}
