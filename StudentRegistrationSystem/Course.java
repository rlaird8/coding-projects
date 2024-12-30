import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    private String term;
    private String year;
    private String dept;
    private String number;
    private String name;
    private int enrolled;
    private int cap;
    private int semHours;
    private ArrayList<String> roster = new ArrayList<>();
    private ArrayList<String> waitList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public Course(String[] args) {
        term = args[0];
        year = args[1];
        dept = args[2];
        number = args[3];
        name = args[4];
        try {
            cap = Integer.parseInt(args[5]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        enrolled = 0;

        try {
            cap = Integer.parseInt(args[6]);
        } catch (NumberFormatException s) {
            s.printStackTrace();
        }
        semHours = 0;
    }

    public String getTermAndYear() {
        return this.term + this.year;
    }

    public String getDeptAndNumber() {
        return this.dept + " " + this.number;
    }

    public String getCourseName() {
        return this.name;
    }

    // added choice to join the waitlist
    public boolean addStudent(String uid, StudentBody sb) {
        if (enrolled < cap) {
            isRegistered(uid);
            roster.add(uid);
            enrolled++;
            return true;
        } else {
            waitListPrompt(uid, sb);
        }
        return false;
    }

    public boolean dropStudent(String uid) {
        if (roster.contains(uid)) {
            roster.remove(uid);
            System.out.println("Student: " + uid + " dropped this course.");
            enrolled--;
            if (!waitList.isEmpty()) {
                isSeatFree(uid);
            }

            return true;
        } else {
            System.out.println("Cannot drop student: ID " + uid + " is not present in roster.");
        }
        return false;
    }

    public boolean isRegistered(String uid) {
        if (roster.contains(uid)) {
            dropStudent(uid);
            System.out.println("Student: " + uid + " tried to register for this course more than once.");
            System.out.println("You are already registered for this course, you cannot register again.");
            return true;
        } else {
            return false;
        }

    }

    public boolean isSeatFree(String uid) {
        if (enrolled < cap) {
            roster.add(waitList.get(0));
            waitList.remove(0);
            return true;
        }
        return false;
    }

    public void printRoster(StudentBody sb) {
        int i = 1;
        for (String item : this.roster) {
            System.out.println(i + ". " + item + " " + sb.searchName(item));
            i++;
        }
        return;
    }

    public void printWaitList(StudentBody sb) {
        int i = 1;
        for (String item : this.waitList) {
            System.out.println(i + ". " + item + " " + sb.searchName(item));
            i++;
        }
        return;
    }

    public void waitListPrompt(String uid, StudentBody sb) {
        System.out.println("Class is full, do you want to join the waitlist? Y/N");
        String choice = scan.nextLine();
        if (choice.equals("Y")) {
            waitList.add(uid);
            System.out.println("You have been added to the waitlist!");
            System.out.println("Here are the people that are in the wait list: ");
            printWaitList(sb);

        } else {
            System.out.println("Good luck scheduling!");
        }
    }

}