package functional_programming;

import java.util.Comparator;
import java.util.Set;

public class StreamsAndMonads {

    public static void main(String[] args) {
        Set<Employee> employees = Set.of(new Employee("Ali", 100), new Employee("Mohammad", 200), new Employee("Ali", 150));
        employees.stream().map(Employee::getName).distinct().sorted(Comparator.reverseOrder()).forEach(n -> System.out.format("%s ", n));
    }

}
