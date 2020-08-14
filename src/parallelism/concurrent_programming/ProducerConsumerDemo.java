package parallelism.concurrent_programming;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {

    static class SoupProducer extends Thread {
        private BlockingQueue servingLine;

        public SoupProducer(BlockingQueue servingLine) {
            this.servingLine = servingLine;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    servingLine.add("Bowl #" + i);
                    System.out.format("Served bowl #%d - remaining capacity: %d\n", i, servingLine.remainingCapacity());
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            servingLine.add("no soup for you!");
            servingLine.add("no soup for you!");
        }
    }

    static class SoupConsumer extends Thread {
        private BlockingQueue servingLine;

        public SoupConsumer(BlockingQueue servingLine) {
            this.servingLine = servingLine;
        }

        public void run() {
            while (true) {
                try {
                    String bowl = (String) servingLine.take();
                    if ("no soup for you!".equals(bowl)) break;
                    System.out.format("Ate %s\n", bowl);
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> servingLine = new ArrayBlockingQueue<>(5);
        new SoupConsumer(servingLine).start();
        new SoupConsumer(servingLine).start();
        new SoupProducer(servingLine).start();
    }

}
