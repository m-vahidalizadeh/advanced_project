package functional_programming;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

    interface ThreadSupplier {
        Thread giveMeThread();
    }

    public static void main(String[] args) {

        Supplier<Thread> s1 = Thread::currentThread;

        ThreadSupplier ts = Thread::currentThread;

        Employee mohammad = new Employee("Mohammad", 3000);
        Integer i = mohammad.getSalary();
        Supplier<Integer> s2 = mohammad::getSalary;
        System.out.println(s2.get());

        Consumer<String> c1 = System.out::println;

        Function<Employee, Integer> f1 = Employee::getSalary;
        Integer mohammadSalary = f1.apply(mohammad);

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);

        main2();

    }

    public static <T> void printAll(T[] array, Function<T, String> toStringFun) {
        int i = 0;
        for (T t : array)
            System.out.println(i++ + ":\t" + toStringFun.apply(t));
    }

    public static void main2() {

        Employee[] dept = new Employee[5];
        dept[0] = new Employee("Mohammad", 1500);
        dept[1] = new Employee("Ali", 1600);
        dept[2] = new Employee("Majid", 1700);
        dept[3] = new Employee("Mahnaz", 1800);
        dept[4] = new Employee("Parinaz", 1900);
        printAll(dept, Employee::getName);

        System.out.println("");

        printAll(dept, emp -> "" + emp.getSalary());

    }

}
