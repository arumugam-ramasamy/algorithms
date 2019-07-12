import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable{

    BlockingQueue<TestRecord> messages ;
    Random rand = new Random( ) ;
    NextSequence    nq ;
    NextSequence  oq ;

    public BlockingQueue<TestRecord> getMessages() {
        return messages;
    }

    public void setMessages(BlockingQueue<TestRecord> messages) {
        this.messages = messages;
    }

    public void run() {
        while (true) {
            if (messages.remainingCapacity() > 0) {
                TestRecord rec = new TestRecord(oq.nextSeq(), nq.nextSeq() % 20 ) ;
                messages.add(rec);
            }
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
