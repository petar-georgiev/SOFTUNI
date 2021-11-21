package L03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentByName;

    public StudentRepository() {
        this.studentByName = new HashMap<>();
    }

    public void add(Student student) {
        this.studentByName.put(student.getName(),student);
    }

    public Student get(String name) {
        return this.studentByName.get(name);
    }
}
