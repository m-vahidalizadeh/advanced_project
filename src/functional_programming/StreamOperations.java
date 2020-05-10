package functional_programming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {
        // Generate 10 positive random integers
        Random random = new Random();
        Stream<Integer> randoms = Stream.generate(random::nextInt);
        randoms.filter(n -> n >= 0).distinct().limit(10).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // Test takeWhile
        IntStream.range(0, 100).takeWhile(n -> n < 10).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // Test dropWhile
        IntStream.range(0, 20).dropWhile(n -> n < 10).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // .map
        Map<String, Integer> grades = new HashMap<>() {{
            put("Ali", 20);
            put("Mohammad", 19);
            put("Mahnaz", 19);
        }};
        grades.entrySet().stream().map(Map.Entry::getValue).distinct().sorted(Comparator.reverseOrder())
                .forEach(v -> System.out.format("%d ", v));
        // Sorting example
        System.out.println();
        Employee mohammad = new Employee("Mohammad", 150);
        Employee ali1 = new Employee("Ali", 120);
        Employee ali2 = new Employee("Ali Reza", 110);
        Employee mahnaz = new Employee("Mahnaz", 100);
        Employee parinaz = new Employee("Parinaz", 150);
        Employee[] employees = {mohammad, mahnaz, ali1, ali2, parinaz};
        Arrays.stream(employees).sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .forEachOrdered(e -> System.out.format("%s->%d ", e.getName(), e.getSalary()));
        // Parallel stream- unordered
        System.out.println();
        IntStream.range(1, 100).parallel().unordered().filter(n -> n % 7 == 0).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // Predicate
        System.out.println(Arrays.stream(employees).anyMatch(e -> e.getSalary() > 100));
        System.out.println(Arrays.stream(employees).noneMatch(e -> e.getSalary() > 100));
        System.out.println(Arrays.stream(employees).allMatch(e -> e.getSalary() > 100));
        // toArray
        Employee[] highPaidEmployees = Arrays.stream(employees).filter(e -> e.getSalary() > 110)
                .sorted(Comparator.comparingInt(Employee::getSalary)).toArray(Employee[]::new);
        Arrays.stream(highPaidEmployees).forEach(e -> System.out.format("%s->%d ", e.getName(), e.getSalary()));
        System.out.println();
        System.out.println(Arrays.stream(employees).map(Employee::getName).max(Comparator.comparingInt(String::length))
                .orElse("not found"));
        // .reduce
        System.out.println(Arrays.stream(employees).map(Employee::getSalary).reduce(1, (a, b) -> a * b));
        // .collect
        System.out.println(Stream.of("a", "b", "c", "d", "e", "f", "g")
                .collect(StringBuilder::new,
                        (b, s) -> b.append(" ").append(s),
                        StringBuilder::append
                ).toString());
        System.out.println(Stream.of("a", "b", "c", "d", "e", "f", "g").collect(Collectors.joining()));
        System.out.println(Stream.of("a", "b", "c", "d", "e", "f", "g").collect(Collectors.joining(" ")));
        TreeSet<Employee> employeesTreeSet = Arrays.stream(employees)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getSalary))));
        employeesTreeSet.stream().forEachOrdered(e -> System.out.format("%s->%d ", e.getName(), e.getSalary()));
        // .toMap
        Map<String, Integer> map = Arrays.stream(employees).collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        // group by
        Map<Integer, List<Employee>> groupedEmployees = Arrays.stream(employees).collect(Collectors.groupingBy(e -> e.getSalary()));
        // partition
        Map<Boolean, List<Employee>> partitionedEmployees = Arrays.stream(employees).collect(Collectors.partitioningBy(e -> e.getSalary() > 110));
        System.out.println();
        IntStream.rangeClosed(1, 9).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        System.out.println(Arrays.stream(employees).mapToInt(Employee::getSalary).max().orElse(-1));
    }

}
