import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(int accNo, String name, String password, double amount) {

        Account account = new Account(accNo, name, password, amount);

        accounts.add(account);

        System.out.println("Account Created Successfully.");
    }

    public Account login(int accNo, String password) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accNo &&
                account.getPassword().equals(password)) {

                return account;
            }
        }

        return null;
    }

    public Account searchAccount(int accNo) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accNo) {

                return account;
            }
        }

        return null;
    }

    public void transfer(Account sender, int receiverAcc, double amount) {

        Account receiver = searchAccount(receiverAcc);

        if (receiver == null) {

            System.out.println("Receiver Account Not Found.");
            return;
        }

        if (sender.getBalance() < amount) {

            System.out.println("Insufficient Balance.");
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        // Mini Statement Entries
        sender.addTransaction("Transferred ₹" + amount +
                " to Account " + receiver.getAccountNumber());

        receiver.addTransaction("Received ₹" + amount +
                " from Account " + sender.getAccountNumber());

        System.out.println("Transfer Successful.");
    }
}