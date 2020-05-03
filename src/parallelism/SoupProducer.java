package parallelism;

import java.util.concurrent.BlockingQueue;

public class SoupProducer extends Thread {

    private BlockingQueue servingLine;

    public SoupProducer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                servingLine.add("Bowl #" + i);
                System.out.format("Served Bowl #%d - remaining capacity: %d\n", i, servingLine.remainingCapacity());
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        servingLine.add("no soup for you!");
        servingLine.add("no soup for you~!");
    }
}
