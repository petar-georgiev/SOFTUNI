package L03StudentSystem;

public class CommandHandler {

    private StudentRepository repository;

    public CommandHandler() {
        this.repository = new StudentRepository();
    }

    public String handleCommand(String[] tokens) {
        if (tokens[0].equals("Create")) {
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            this.repository.add(student);
            return null;
        } else if (tokens[0].equals("Show")) {
            String name = tokens[1];
            return repository.get(name).getInfo();
        } else {
            return tokens[0];
        }
    }
}
