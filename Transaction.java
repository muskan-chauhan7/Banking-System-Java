public class Transaction {
    String type;
    double amount;
    String date;
    double balanceAfter;

    public Transaction(String type, double amount, String date, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balanceAfter = balanceAfter;
    }
}