package functional_programming;

import java.util.Arrays;
import java.util.Comparator;

public class ComparingComposeExample {

    public static void main(String[] args) {
        Employee mohammad = new Employee("Mohammad", 150);
        Employee ali1 = new Employee("Ali", 120);
        Employee ali2 = new Employee("Ali", 110);
        Employee mahnaz = new Employee("Mahnaz", 100);

        Employee[] employees = {mohammad, mahnaz, ali1, ali2};

        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        printArray(employees);

        Arrays.sort(employees, Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary, Comparator.reverseOrder()));
        printArray(employees);

        Arrays.sort(employees, Comparator.comparing(Employee::getName, Comparator.reverseOrder())
                .thenComparing(Employee::getSalary, Comparator.reverseOrder()));
        printArray(employees);
    }

    private static void printArray(Employee[] employees) {
        for (Employee e : employees) {
            System.out.format("%s->%s ", e.getName(), e.getSalary());
        }
        System.out.println();
    }

}
