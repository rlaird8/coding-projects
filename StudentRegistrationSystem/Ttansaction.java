import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

class Transaction {
    private enum type {
        DR, CR
    }; // DR = debit, CR = credit

    private BigDecimal amount;
    private String label;

    public Transaction() {
        BigDecimal amount = new BigDecimal(0);
        label = "0";
    }

    // TODO: write a constructor, and use a regex to validate file input to validate
    // the parameters you send to it.
}