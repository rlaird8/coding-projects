import java.util.ArrayList;

public class Catalog {
    private ArrayList<Course> courseList;

    public Catalog() {
        courseList = new ArrayList<Course>();
    }

    public void add(Course c) {
        courseList.add(c);
    }

}

// ArrayList<Course> course = new ArrayList<Course>();