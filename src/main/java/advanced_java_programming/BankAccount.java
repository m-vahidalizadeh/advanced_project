package advanced_java_programming;

public class BankAccount {

    private int balance = 100;

    void debit(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

}
