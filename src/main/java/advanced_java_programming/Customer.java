package advanced_java_programming;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {

    public static void main(String[] args){
        ATM atm=new ATM();
        BankAccount account=new BankAccount();
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(() -> atm.withdraw(account, 100));
            executorService.submit(() -> atm.withdraw(account, 100));
        }
    }

}
