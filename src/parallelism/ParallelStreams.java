package parallelism;

import functional_programming.Employee;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {
        Employee mohammad = new Employee("Mohammad", 150);
        Employee ali1 = new Employee("Ali", 120);
        Employee ali2 = new Employee("Ali Reza", 110);
        Employee mahnaz = new Employee("Mahnaz", 100);
        Employee parinaz = new Employee("Parinaz", 150);
        Employee[] employees = {mohammad, mahnaz, ali1, ali2, parinaz};
        // Sequential
        System.out.println(Arrays.stream(employees).mapToInt(Employee::getSalary).sum());
        class Adder1 {
            int total;

            public void accept(int n) {
                total += n;
            }
        }
        Adder1 adder1 = new Adder1();
        IntStream.rangeClosed(1, 100).forEach(adder1::accept);
        System.out.println(adder1.total);
        // Parallel
        System.out.println(Arrays.stream(employees).parallel().mapToInt(Employee::getSalary).sum());
        adder1 = new Adder1();
        // Unsafe adding- race condition
        IntStream.rangeClosed(1, 100).parallel().forEach(adder1::accept);
        System.out.println(adder1.total);
        // Safe- solution 1
        class Adder2 {
            int total;

            public synchronized void accept(int n) {
                total += n;
            }
        }
        Adder2 adder2 = new Adder2();
        IntStream.rangeClosed(1, 100).parallel().forEach(adder2::accept);
        System.out.println(adder2.total);
        // Safe- solution 2
        class Adder3 {
            LongAdder total = new LongAdder();

            public void accept(int n) {
                total.add(n);
            }
        }
        Adder3 adder3 = new Adder3();
        IntStream.rangeClosed(1, 100).parallel().forEach(adder3::accept);
        System.out.println(adder3.total.longValue());
    }

}
