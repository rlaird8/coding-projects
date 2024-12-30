import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private String uid;

    public Student(String fname, String lname, String ynum) {
        this.firstName = fname;
        this.lastName = lname;
        this.uid = ynum;
    }

    private Account acc;

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

    public void createID() {

    }
}
