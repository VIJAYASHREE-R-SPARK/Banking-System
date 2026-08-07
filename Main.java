import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        while (true) {

            System.out.println("\n====== BANKING SYSTEM ======");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Account Number : ");
                    int acc = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Password : ");
                    String pass = sc.nextLine();

                    System.out.print("Initial Deposit : ");
                    double amount = sc.nextDouble();

                    bank.createAccount(acc, name, pass, amount);

                    break;

                case 2:

                    System.out.print("Account Number : ");
                    int no = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Password : ");
                    String pwd = sc.nextLine();

                    Account user = bank.login(no, pwd);

                    if (user == null) {

                        System.out.println("Invalid Login");
                        break;

                    }

                    boolean login = true;

                    while (login) {

                        System.out.println("\n========== WELCOME " + user.getName() + " ==========");

                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Transfer");
                        System.out.println("5. Account Details");
                        System.out.println("6. Mini Statement");
                        System.out.println("7. Logout");

                        System.out.print("Enter Choice : ");
                        int ch = sc.nextInt();

                        switch (ch) {

                            case 1:

                                System.out.print("Enter Amount : ");
                                double dep = sc.nextDouble();

                                user.deposit(dep);

                                break;

                            case 2:

                                System.out.print("Enter Amount : ");
                                double wd = sc.nextDouble();

                                user.withdraw(wd);

                                break;

                            case 3:

                                System.out.println("Current Balance : ₹" + user.getBalance());

                                break;

                            case 4:

                                System.out.print("Receiver Account Number : ");
                                int rec = sc.nextInt();

                                System.out.print("Enter Amount : ");
                                double am = sc.nextDouble();

                                bank.transfer(user, rec, am);

                                break;

                            case 5:

                                user.showDetails();

                                break;

                            case 6:

                                user.showMiniStatement();

                                break;

                            case 7:

                                login = false;
                                System.out.println("Logged Out Successfully.");

                                break;

                            default:

                                System.out.println("Invalid Choice.");

                        }

                    }

                    break;

                case 3:

                    System.out.println("Thank You for Using Banking System.");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}