import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class DemoTask implements Runnable {
    private String name = null;
    BlockingQueue<TestRecord> messages;


    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public BlockingQueue<TestRecord> getMessages() {
        return messages;
    }

    public void setMessages(BlockingQueue<TestRecord> messages) {
        this.messages = messages;
    }

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            Random rand = new Random() ;
            try {
                //TestRecord rec = messages.g
                Thread.sleep(rand.nextInt(10000));

                System.out.println(messages.take());
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
            System.out.println("Executing : " + name);
        }
    }
}


