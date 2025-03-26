import java.util.ArrayList;

public class StudentBody {
    private ArrayList<Student> studentList;

    public StudentBody() {
        studentList = new ArrayList<Student>();
    }

    public Student getStudent(int i) {
        return studentList.get(i);
    }

    public boolean isEnrolled(String uid) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getUid() == uid) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public String searchName(String uid) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getUid() == uid) {
                return studentList.get(i).getName();
            }
        }
        return "Student" + uid + " was not found";
    }

    public void printStudentBody() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i + ". " + "The student is: " + studentList.get(i).getName());
        }
    }

}

// ArrayList<Student> studentList = new ArrayList<Student>();