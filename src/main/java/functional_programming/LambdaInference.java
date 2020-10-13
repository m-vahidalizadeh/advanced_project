package functional_programming;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class LambdaInference {

    public static void main(String[] args) {
        Consumer<String> c1 = msg -> System.out.println(msg.length());

//        Object x1=msg->System.out.println(msg.length());

//        Object x2=(String msg)-> System.out.println(msg.length());

        Object x3 = (Consumer<String>) ((String msg) -> System.out.println(msg.length()));

        Consumer<?> c2 = msg -> System.out.println(msg);

//        Consumer<?> c3=msg-> System.out.println(msg.length());

        Consumer<?> c4 = (String msg) -> System.out.println(msg.length());

    }

    public static <T extends Employee> T testWithNull(UnaryOperator<T> transformer) {
        return transformer.apply(null);
    }

    public static void main2() {
        UnaryOperator<Manager> doubleBonus = manager -> new Manager(manager.getName(), manager.getSalary(), 2 * manager.getBonus());

        Manager test1 = testWithNull(doubleBonus);

        Manager test2 = testWithNull(manager -> new Manager(manager.getName(), manager.getSalary(), 2 * manager.getBonus()));

//        Employee test3=testWithNull(manager->new Manager(manager.getName(),manager.getSalary(),2*manager.getBonus()));

    }

}
