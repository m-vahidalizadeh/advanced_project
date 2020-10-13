package functional_programming;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {

    public static void main(String[] args) {

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        Comparator<Employee> byNameLambda1 = (Employee a, Employee b) -> {
            return a.getName().compareTo(b.getName());
        };

        Comparator<Employee> byNameLambda2 = (a, b) -> {
            return a.getName().compareTo(b.getName());
        };

        Comparator<Employee> byNameLambda3 = (a, b) -> a.getName().compareTo(b.getName());

//        Comparator<Employee> byNameLambda4=(a,b)->return a.getName().compareTo(b.getName());

        Runnable r = () -> {
            System.out.println("A compact Runnable!");
        };
        Thread t1 = new Thread(r);

        Thread t2 = new Thread(() -> {
            System.out.println("Am implicit Runnable!");
        });

        Thread t3 = new Thread(() -> System.out.println("An implicit Runnable!"));

        Consumer<String> lengthPrinter = s -> System.out.println(s.length());

    }

}
