
// RYAN RUSSELL LAIRD
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {

    StudentBody sb = new StudentBody();
    Catalog catalog1 = new Catalog();
    String line = "";
    String pattern = "(Y[0-9]{8})\\s+(\\w+)\\s(\\w+)\\s?";
    Pattern r = Pattern.compile(pattern);
    System.out.println();
    System.out.println("These are the Students that passed the regex check: ");
    try (Scanner input = new Scanner(Paths.get("./Student.txt"))) {
      while (input.hasNextLine()) {
        line = input.nextLine();
        Matcher m = r.matcher(line);
        if (m.find()) {
          String[] studentParams = { m.group(1), m.group(2), m.group(3) };
          Student s = new Student(studentParams);
          sb.addStudent(s);
        } else {
          System.out.println("NO MATCH");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    sb.printStudentBody();
    System.out.println();

    System.out.println("These are the courses that passed the regex check: ");
    String courseString = "";
    pattern = "(S|X|F)(2[0-9]{3})\\s+([A-Z]{3,})\\s+([1-5][0-9]{3})\\s+(([A-Za-z-]+\\s)+([A-Za-z]+))\\s+([0-9]{1,})\\s([0-9]{1})";
    r = Pattern.compile(pattern);
    try (Scanner input = new Scanner(Paths.get("./Course.txt"))) {
      // read record from file
      while (input.hasNextLine()) {
        courseString = input.nextLine();
        Matcher m = r.matcher(courseString);
        if (m.find()) {
          String[] courseParams = { m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(8),
              m.group(9) };
          Course c = new Course(courseParams);
          catalog1.addCourse(c);
        } else {
          System.out.println("NO MATCH");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < catalog1.getCatalog().size(); i++) {
      catalog1.printCourses(i);

    }
    System.out.println();
    Scanner scan = new Scanner(System.in);

    Student s = null;
    Course c = null;
    Course temp = null;
    int stuNumInput;

    // IN ORDER TO ACCESS THE PAY OPTION, FINALIZE THEIR SCHEDULE FIRST. THIS
    // UPDATES THE TRANSACTION BALANCE

    // IF YOU WANT TO FINALIZE THE SCHEDULE AGAIN, RERUN THE PROGRAM

    while (true) {
      System.out.println("Pick a student (0-8): ");
      sb.printStudentBody();
      stuNumInput = scan.nextInt();
      s = sb.getStudent(stuNumInput);

      System.out.println("Select option: ");
      System.out.println("1. Add student to course: ");
      System.out.println("2. Drop student from course: ");
      System.out.println("3. Finalize schedule: ");
      System.out.println("4. Pay: ");
      int input1 = scan.nextInt();

      switch (input1) {
        case 1: {
          System.out.println("What class do you want to select for: " + s.getName());
          System.out.println("\nSelect class:");
          System.out.println("1. CSIS 3701 Advanced Object Oriented Programming");
          System.out.println("2. CSCI 3710 Introduction to Discrete Structures");
          System.out.println("3. 4850 Advanced Database Design and Administration");
          System.out.println("4. CSCI 5801 Software Engineering");
          System.out.println("5. CSIS 2610 Programming and Problem Solving");
          System.out.println("6. CSCI 4852 Deep Learning");
          System.out.println("7. 4862 Server-Side Web Development and Programming");
          int courseChoice = scan.nextInt();
          temp = catalog1.getClass(courseChoice);
          temp.addStudent(courseString, sb, s, temp);
          break;
        }
        case 2: {
          System.out.println("What class do you want to drop: " + s.getName() + " from?");
          System.out.println("\nSelect class:");
          System.out.println("1. CSIS 3701 Advanced Object Oriented Programming");
          System.out.println("2. CSCI 3710 Introduction to Discrete Structures");
          System.out.println("3. 4850 Advanced Database Design and Administration");
          System.out.println("4. CSCI 5801 Software Engineering");
          System.out.println("5. CSIS 2610 Programming and Problem Solving");
          System.out.println("6. CSCI 4852 Deep Learning");
          System.out.println("7. 4862 Server-Side Web Development and Programming");
          int courseChoice = scan.nextInt();
          temp = catalog1.getClass(courseChoice);
          temp.dropStudent(courseString, s, temp);
          break;
        }
        case 3: {
          if (!s.getIsFinalized()) {
            System.out.println(s.getName() + " was selected");
            s.finalizeSchedule();
            BigDecimal sum = s.getAccount().getTransactions().stream().map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            s.getAccount().setBalance(sum);
            // System.out.println(sum);
            System.out.println(s.getUid() + " " + s.getName() + "'s new debit value " + s.getAccount().getBalance());
          }
          break;
        }

        case 4: {
          System.out.println(s.getName() + "'s current balance is $" + s.getAccount().getBalance());
          System.out.println("Enter the amount of money that you are paying: ");
          BigDecimal userAmount = BigDecimal.valueOf(scan.nextInt());
          s.payBills(userAmount);
          System.out.println("Student " + s.getName() + " paid $" + userAmount);
          System.out.println("Their new balance is: " + s.getAccount().getBalance());
          break;
        }
      }
    }
  }
}
