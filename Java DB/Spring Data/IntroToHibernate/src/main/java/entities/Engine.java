package entities;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Select ex number:");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());

            switch (exNum) {
                case 2 -> exTwo();
                case 3 -> exThree();
                case 4 -> exFour();
                case 5 -> exFive();
                case 6 -> exSix();
                case 7 -> exSeven();
                case 8 -> exEight();
                case 9 -> exNine();
                case 10 -> exTen();
                case 11 -> exEleven();
                case 12 -> exTwelve();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    @SuppressWarnings("unchecked")
    private void exTwelve() {
        List<Object[]> list = entityManager.createQuery("select e.department.name, max(e.salary) from Employee e " +
                        "group by e.department.id " +
                        "having max(e.salary) not between 30000 and 70000")
                .getResultList();

        for (Object[] objects : list) {
            System.out.printf("%s %.2f%n",
                    objects[0],
                    objects[1]);
        }
    }

    private void exEleven() throws IOException {
        System.out.println("Input pattern:");
        String pattern = bufferedReader.readLine();

        entityManager.createQuery(
                        "select e from Employee e " +
                                "where e.firstName like concat(:p_pattern, '%')", Employee.class
                ).setParameter("p_pattern", pattern)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            e.getSalary());
                });
    }

    private void exTen() {
        List<Employee> employees = entityManager.createQuery("select e FROM Employee e " +
                        "where e.department.id IN (1,2,4,11)", Employee.class)
                .getResultList();
        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.12")));
            entityManager.persist(employee);
        }
        entityManager.getTransaction().commit();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getSalary()
        ));
    }

    private void exNine() {
        entityManager.createQuery("select p FROM Project p " +
                        "order by p.startDate desc, p.name ", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(p -> {
                    System.out.printf(
                            "Project name: %s%n" +
                                    "Project Description: %s%n" +
                                    "Project Start Date: %s%n" +
                                    "Project End Date: %s%n%n",
                            p.getName(),
                            p.getDescription(),
                            p.getStartDate()
                                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.s")),
                            p.getEndDate());
                });
    }

    private void exEight() throws IOException {
        System.out.println("Input id:");
        int id = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager
                .find(Employee.class, id);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee
                .getProjects()
                .stream()
                .map(Project::getName)
                .sorted()
                .forEach(System.out::println);
    }

    private void exSeven() {
        entityManager
                .createQuery("select a from Address as a " +
                        "order by a.employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s, %s - %s employees%n",
                            e.getText(),
                            e.getTown() == null
                                    ? "Unknown"
                                    : e.getTown().getName(),
                            e.getEmployees().size());
                });
    }

    private void exSix() throws IOException {
        System.out.println("Input last name:");
        String lName = bufferedReader.readLine();

        try {
            Employee employee = entityManager.createQuery("select e from Employee as e " +
                            "where :l_name = e.lastName", Employee.class)
                    .setParameter("l_name", lName).getSingleResult();

            Address address = new Address();
            address.setText("Vitoshka 15");

            entityManager.getTransaction().begin();
            entityManager.persist(address);
            employee.setAddress(address);
            entityManager.getTransaction().commit();

            System.out.println("Query has been successfully!");

        } catch (Exception e) {
            System.out.println("Pls input again last name!");
        }
    }

    private void exFive() {
        entityManager
                .createQuery("select e from Employee as e " +
                        "where e.department.name = :d_name " +
                        "order by e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void exFour() {
        entityManager
                .createQuery("select e from Employee e" +
                        " where e.salary>:min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000))
                .getResultStream()
                .forEach(employee -> {
                    System.out.println(employee.getFirstName());
                });
    }

    private void exThree() throws IOException {
        System.out.println("Enter employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("select count (e) from Employee e" +
                                " where e.firstName = :f_name and e.lastName = :l_name",
                        long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0
                ? "Yes"
                : "No");

    }

    private void exTwo() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update Town t " +
                "set t.name = upper(t.name)" +
                "where length(t.name) < 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();


    }
}
