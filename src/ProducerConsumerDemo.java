import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        BlockingQueue servingLine = new ArrayBlockingQueue<String>(5);
        new SoupConsumer(servingLine).start();
        new SoupConsumer(servingLine).start();
        new SoupProducer(servingLine).start();

    }

}
