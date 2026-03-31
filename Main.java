import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account loggedIn = null;

        while (true) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // 🔹 REGISTER
                case 1:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Set Password: ");
                    String password = sc.nextLine();

                    System.out.print("Initial Deposit: ");
                    double deposit = sc.nextDouble();

                    BankService.register(name, address, phone, password, deposit);
                    break;

                // 🔹 LOGIN
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pwd = sc.nextLine();

                    loggedIn = BankService.login(accNo, pwd);

                    // If login successful
                    if (loggedIn != null) {
                        System.out.println("✅ Login Successful!");

                        while (true) {
                            System.out.println("\n----- ACCOUNT MENU -----");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Transfer");
                            System.out.println("4. View Statement");
                            System.out.println("5. Logout");
                            System.out.print("Enter choice: ");

                            int ch = sc.nextInt();

                            switch (ch) {

                                case 1:
                                    System.out.print("Enter amount to deposit: ");
                                    double depAmt = sc.nextDouble();
                                    BankService.deposit(loggedIn, depAmt);
                                    break;

                                case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    double withAmt = sc.nextDouble();
                                    BankService.withdraw(loggedIn, withAmt);
                                    break;

                                case 3:
                                    System.out.print("Enter Receiver Account Number: ");
                                    int toAcc = sc.nextInt();

                                    System.out.print("Enter amount to transfer: ");
                                    double amt = sc.nextDouble();

                                    BankService.transfer(loggedIn, toAcc, amt);
                                    break;

                                case 4:
                                    BankService.showStatement(loggedIn);
                                    break;

                                case 5:
                                    System.out.println("🔒 Logged out successfully.");
                                    loggedIn = null;
                                    break;

                                default:
                                    System.out.println("❌ Invalid choice!");
                            }

                            if (ch == 5) break;
                        }
                    }
                    break;

                // 🔹 EXIT
                case 3:
                    System.out.println("👋 Thank you for using Banking System!");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}