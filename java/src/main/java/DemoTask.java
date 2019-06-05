import java.util.concurrent.BlockingQueue;

public class DemoTask implements Runnable {
    private String name = null;
    BlockingQueue<String> messages;


    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public BlockingQueue<String> getMessages() {
        return messages;
    }

    public void setMessages(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println(messages.take());
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
            System.out.println("Executing : " + name);
        }
    }
}


