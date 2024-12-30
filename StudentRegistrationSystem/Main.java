import java.util.Scanner;
// example object messaging

public class Main {
    public static void main(String[] args) {

        StudentBody sb = new StudentBody();
        Catalog c = new Catalog();

        String[] course1 = { "F", "2022", "CSIS", "3701", "Advanced Object Oriented Programming", "32", "3" };
        String[] course2 = { "F", "2022", "CSCI", "3710", "Introduction to Discrete Structures", "32", "3" };
        String[] course3 = { "F", "2022", "CSCI", "4850", "Advanced Database Design and Administration", "2", "3" };
        String[] course4 = { "F", "2022", "CSCI", "5801", "Software Engineering", "2", "3" };
        String[] course5 = { "F", "2022", "CSIS", "2610", "Programming and Problem Solving", "32", "3" };
        String[] course6 = { "F", "2022", "CSCI", "4852", "Deep Learning", "32", "3" };
        String[] course7 = { "F", "2022", "CSCI", "4862", "Server-Side Web Development and Programming", "32", "3" };

        Course csis3701 = new Course(course1);
        Course csci3710 = new Course(course2);
        Course csci4850 = new Course(course3);
        Course csci5801 = new Course(course4);
        Course csis2610 = new Course(course5);
        Course csci4852 = new Course(course5);
        Course csci4862 = new Course(course5);

        Student kirk = new Student("Kirk", "Cousins", "Y00123456");
        Student leonard = new Student("Leonard", "Fournette", "Y00234567");
        Student saquon = new Student("Saquon", "Barkley", "Y00234568");
        Student cooper = new Student("Cooper", "Kupp", "Y00234569");
        Student dk = new Student("DK", "Metcalf", "Y00234570");
        Student gerald = new Student("Gerald", "Everett", "Y00234571");
        Student david = new Student("David", "Montgomery", "Y00234572");
        Student clyde = new Student("Clyde-Edwards", "Helaire", "Y00234573");
        Student daniel = new Student("Daniel", "Carlson", "Y00234574");

        c.add(csis2610);
        c.add(csis3701);
        c.add(csci3710);
        c.add(csci4850);
        c.add(csci5801);

        sb.add(kirk);
        sb.add(leonard);
        sb.add(saquon);
        sb.add(cooper);
        sb.add(dk);
        sb.add(gerald);
        sb.add(david);
        sb.add(clyde);
        sb.add(daniel);

        // ex1.setFirstName("Jane");
        // ex1.setLastname("Doe");
        // ex1.setUid("Y00123456");

        // ex2.setFirstname("John");
        // ex2.setLastname("Smith");
        // ex2.setUid("Y00234567");

        Student[] students = { kirk, leonard, saquon, cooper, dk, gerald, david, clyde, daniel };

        Scanner scan = new Scanner(System.in);

        System.out.println("Here is the list of students:");
        System.out.println(kirk.getName());
        System.out.println(leonard.getName());
        System.out.println(saquon.getName());
        System.out.println(cooper.getName());
        System.out.println(dk.getName());
        System.out.println(gerald.getName());
        System.out.println(david.getName());
        System.out.println(clyde.getName());
        System.out.println(daniel.getName());

        System.out.println("\nHere are the course details:");
        System.out.println(csis3701.getCourseName());
        System.out.println(csis3701.getTermAndYear());
        System.out.println(csis3701.getDeptAndNumber());

        System.out.println();

        System.out.println("\nHere are the course details:");
        System.out.println(csci3710.getCourseName());
        System.out.println(csci3710.getTermAndYear());
        System.out.println(csci3710.getDeptAndNumber());

        System.out.println();

        System.out.println("\nHere are the course details:");
        System.out.println(csci4850.getCourseName());
        System.out.println(csci4850.getTermAndYear());
        System.out.println(csci4850.getDeptAndNumber());

        System.out.println();

        System.out.println("\nHere are the course details:");
        System.out.println(csci5801.getCourseName());
        System.out.println(csci5801.getTermAndYear());
        System.out.println(csci5801.getDeptAndNumber());

        System.out.println();

        System.out.println("\nHere are the course details:");
        System.out.println(csis2610.getCourseName());
        System.out.println(csis2610.getTermAndYear());
        System.out.println(csis2610.getDeptAndNumber());

        System.out.println();

        // PREVENTING DOUBLE REGISTRATION

        csis2610.addStudent(david.getUid(), sb);
        csis2610.addStudent(dk.getUid(), sb);
        csis2610.addStudent(daniel.getUid(), sb);
        csis2610.addStudent(gerald.getUid(), sb);
        csis2610.addStudent(gerald.getUid(), sb);
        System.out.println();
        csis2610.printRoster(sb);

        // WAITLIST DEMONSTRATED

        csci5801.addStudent(kirk.getUid(), sb);
        csci5801.addStudent(leonard.getUid(), sb);
        csci5801.addStudent(clyde.getUid(), sb);
        csci5801.addStudent(dk.getUid(), sb);
        csci5801.addStudent(cooper.getUid(), sb);
        System.out.println();
        csci5801.printRoster(sb);
        // AUTO ENROLL DEMONSTRATED

        csis3701.addStudent(kirk.getUid(), sb);
        csis3701.addStudent(leonard.getUid(), sb);
        csis3701.addStudent(saquon.getUid(), sb);
        csis3701.dropStudent(leonard.getUid());
        csis3701.printRoster(sb);
        // PRINT ROSTER DEMONSTRATED
        System.out.println("\nCurrent Roster for CSIS3701: ");
        csis3701.printRoster(sb);
        System.out.println();

        csci3710.addStudent(students[1].getUid(), sb);
        csci3710.addStudent(students[1].getUid(), sb);
        csci3710.addStudent(students[4].getUid(), sb);
        csci3710.addStudent(students[8].getUid(), sb);
        System.out.println("\nCurrent Roster for CSCI3710: ");
        csci3710.printRoster(sb);

        // 2 PEOPLE ADDED FROM WAITLIST IN SEQUENTIAL ORDER

        csci4850.addStudent(kirk.getUid(), sb);
        csci4850.addStudent(clyde.getUid(), sb);
        csci4850.addStudent(david.getUid(), sb);
        csci4850.addStudent(daniel.getUid(), sb);
        csci4850.dropStudent(kirk.getUid());
        csci4850.dropStudent(clyde.getUid());
        csci4850.printRoster(sb);
        System.out.println();
        return;
    }
}