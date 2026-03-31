import java.util.ArrayList;

public class Account {
    int accountNumber;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}