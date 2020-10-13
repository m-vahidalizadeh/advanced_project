package functional_programming;

import java.util.Comparator;

public class Interfaces {

    public static void main(String[] args) {
        Employee mohammad = new Employee("Mohammad", 2000), ali = new Employee("Ali", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        System.out.println("By name:");
        System.out.println(byName.compare(mohammad, ali));

        try {
            System.out.println(byName.compare(mohammad, null));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        Comparator<Employee> byNameThenNull = Comparator.nullsLast(byName);
        System.out.println("Then null:");
        System.out.println(byNameThenNull.compare(mohammad, ali));
        System.out.println(byNameThenNull.compare(mohammad, null));


        Comparator<Employee> nullThenByDecreasingName = byNameThenNull.reversed();
        System.out.println("Reversed:");
        System.out.println(nullThenByDecreasingName.compare(mohammad, ali));
        System.out.println(nullThenByDecreasingName.compare(mohammad, null));

    }

}
