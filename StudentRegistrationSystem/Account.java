import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ArrayList;

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

    // Use this lambda
    // BigDecimal sum =
    // Transaction.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO,
    // BigDecimal::add);

}