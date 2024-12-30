import java.util.ArrayList;

public class StudentBody {
    private ArrayList<Student> studentList;

    public StudentBody() {
        studentList = new ArrayList<Student>();
    }

    public boolean isEnrolled(String uid) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getUid() == uid) {
                return true;
            }
        }
        return false;
    }

    public void add(Student s) {
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

}

// ArrayList<Student> studentList = new ArrayList<Student>();