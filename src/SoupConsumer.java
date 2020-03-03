import java.util.concurrent.BlockingQueue;

public class SoupConsumer extends Thread {

    private BlockingQueue servingLine;

    public SoupConsumer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String bowl = (String) servingLine.take();
                if ("no soup for you!" == bowl)
                    break;
                System.out.format("Ate %s\n", bowl);
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
