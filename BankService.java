import java.util.*;

public class BankService {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();
    static Random rand = new Random();

    // STEP 5 METHODS (Already added)
    public static int generateAccountNumber() {
        return 10000 + rand.nextInt(90000);
    }

    public static void register(String name, String address, String phone, String password, double deposit) {
        int accNo = generateAccountNumber();
        User user = new User(name, address, phone, password, accNo);
        Account acc = new Account(accNo, deposit);

        users.add(user);
        accounts.add(acc);

        System.out.println("✅ Registered Successfully! Account Number: " + accNo);
    }

    public static Account login(int accNo, String password) {
        for (User u : users) {
            if (u.accountNumber == accNo && u.password.equals(password)) {
                for (Account acc : accounts) {
                    if (acc.accountNumber == accNo) {
                        return acc;
                    }
                }
            }
        }
        System.out.println("❌ Invalid login!");
        return null;
    }

    // 🔽 🔽 🔽 ADD STEP 6 HERE 🔽 🔽 🔽

    public static void deposit(Account acc, double amount) {
        acc.balance += amount;
        acc.transactions.add(new Transaction("Deposit", amount, new Date().toString(), acc.balance));
        System.out.println("✅ Deposited! New Balance: " + acc.balance);
    }

    public static void withdraw(Account acc, double amount) {
        if (acc.balance >= amount) {
            acc.balance -= amount;
            acc.transactions.add(new Transaction("Withdraw", amount, new Date().toString(), acc.balance));
            System.out.println("✅ Withdrawn! New Balance: " + acc.balance);
        } else {
            System.out.println("❌ Insufficient Balance!");
        }
    }

    public static void transfer(Account from, int toAccNo, double amount) {
        for (Account acc : accounts) {
            if (acc.accountNumber == toAccNo) {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    acc.balance += amount;

                    from.transactions.add(new Transaction("Transfer Sent", amount, new Date().toString(), from.balance));
                    acc.transactions.add(new Transaction("Transfer Received", amount, new Date().toString(), acc.balance));

                    System.out.println("✅ Transfer Successful!");
                    return;
                } else {
                    System.out.println("❌ Insufficient Balance!");
                    return;
                }
            }
        }
        System.out.println("❌ Account not found!");
    }

    public static void showStatement(Account acc) {
        if (acc.transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (Transaction t : acc.transactions) {
            System.out.println(t.type + " | " + t.amount + " | " + t.date + " | Balance: " + t.balanceAfter);
        }
    }
}