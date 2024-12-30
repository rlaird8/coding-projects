import java.util.ArrayList;

public class Catalog {
    private ArrayList<Course> courseList;

    public Catalog() {
        courseList = new ArrayList<Course>();
    }

    public ArrayList<Course> getCatalog() {
        return courseList;
    }

    public Course getClass(int i) {
        return courseList.get(i - 1);
    }

    public void addCourse(Course c) {
        courseList.add(c);
    }

    public void printCourses(int i) {
        System.out.println(courseList.get(i).getTermAndYear() + " " + courseList.get(i).getDeptAndNumber() + " "
                + courseList.get(i).getCourseName());
    }

}

// ArrayList<Course> course = new ArrayList<Course>();