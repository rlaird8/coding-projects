import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private enum Type {
        DR, CR
    }; // DR = debit, CR = credit

    private BigDecimal amount;
    private String label;
    Type t;

    public Transaction(BigDecimal amount, String label) {
        this.label = label;
        if (label.equals("schedule") || label.equals("charge")) {
            t = Type.DR;
        } else {
            t = Type.CR;
        }
        if (label.equals("schedule") || label.equals("charge")) {
            this.amount = amount;
        } else {
            this.amount = amount.subtract(amount.multiply(BigDecimal.valueOf(2)));
        }
    }

    public Transaction() {
        amount = new BigDecimal(0);
        label = "";
        t = Type.CR;
    }

    // TODO: write a constructor, and use a regex to validate file input to validate
    // the parameters you send to it.

    public Type getType() {
        if (label == "tuition") {
            return Type.CR;
        }
        return Type.DR;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        // TODO: the string representation of a Transaction
        return "";
    }

    public void setAmount(BigDecimal a) {
        amount = a;
    }

}

class Account {
    private ArrayList<Transaction> transactions;
    private BigDecimal balance;

    public Account() {
        transactions = new ArrayList<Transaction>();
        balance = new BigDecimal(0);
    }

    public void setBalance(BigDecimal b) {
        balance = b;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction t1) {
        transactions.add(t1);
    }

    // Use this lambda
    // BigDecimal sum =
    // Transaction.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO,
    // BigDecimal::add);

}

public class Student {

    private String firstName;
    private String lastName;
    private String uid;
    private int creditNum;
    private Account acc;
    private boolean isFinalized = false;

    public Student(String[] args) {
        uid = args[0];
        firstName = args[1];
        lastName = args[2];
        acc = new Account();
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
        return;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
        return;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getUid() {
        return this.uid;
    }

    public Account getAccount() {
        return acc;
    }

    public Boolean getIsFinalized() {
        return isFinalized;
    }

    public void createID() {

    }

    public void addCredits(int c) {
        creditNum += c;
        System.out.println("Your current number of semester hours for this student: " + creditNum);
    }

    public void removeCredits(int c) {
        creditNum -= c;
    }

    public void payBills(BigDecimal userAmount) {
        Transaction paid = new Transaction();
        paid.setAmount(userAmount);
        acc.setBalance(acc.getBalance().subtract(userAmount));
        acc.addTransaction(paid);
    }

    public void finalizeSchedule() {
        Transaction t1 = new Transaction();
        // Account ac = new Account();
        if (creditNum < 12 || creditNum > 18) {
            t1.setAmount(BigDecimal.valueOf(creditNum * 270));
            acc.addTransaction(t1);
        } else if (creditNum >= 12 && creditNum <= 18) {
            t1.setAmount(BigDecimal.valueOf(3240));
            acc.addTransaction(t1);
        } else {
            System.out.println("Enter a valid number");
        }
    }
}
