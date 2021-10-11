package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                this.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int maxAge = Integer.MIN_VALUE;
        for (Employee employee : this.employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
            }
        }
        for (Employee employee : this.employees) {
            if (employee.getAge() == maxAge)
                return employee;
        }
        return null;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(
                String.format("Employees working at Bakery %s:%n", this.name));
        for (Employee employee : employees) {
            sb.append(employee + System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
