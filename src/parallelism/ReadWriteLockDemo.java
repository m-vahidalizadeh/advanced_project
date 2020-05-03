package parallelism;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new CalendarUser("Reader-" + i).start();
        for (int i = 0; i < 2; i++)
            new CalendarUser("Writer-" + i).start();
    }

}
