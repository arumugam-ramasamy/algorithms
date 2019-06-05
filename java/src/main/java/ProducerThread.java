import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable{

    BlockingQueue<String> messages ;

    public BlockingQueue<String> getMessages() {
        return messages;
    }

    public void setMessages(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    public void run() {
        while (true) {
            if (messages.remainingCapacity() > 0)
            messages.add(NextSequence.nextSeq().toString() + " value of next next seq");
            else{
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {

                }
            }
        }
    }
}
