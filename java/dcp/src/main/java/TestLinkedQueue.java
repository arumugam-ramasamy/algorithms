import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestLinkedQueue {

    int capacityQueue = 100 ;

    BlockingQueue <TestRecord> lq = null ;
    Iterator <TestRecord> iter  = null ;

    public TestLinkedQueue () {

        lq = new LinkedBlockingDeque<>(capacityQueue) ;
        iter = lq.iterator() ;

    }

    public void  createQ () {

        Random rand = new Random( ) ;
        for (int i = 0 ; i < 100 ; i++)
            lq.add(new TestRecord(rand.nextInt(100))) ;
        iter = lq.iterator() ;
    }

    public void setFlag () {
        Iterator<TestRecord> iter = lq.iterator() ;

        while (iter.hasNext()) {
            TestRecord rec = iter.next() ;
            rec.setProcessed(true);
        }

    }

    public void printRecs() {
        TestRecord rec ;
        rec = getNext() ;
        while (rec != null) {
            System.out.println(rec.getProcessed() + " value, " + rec.getNumber() + " , " + rec.getCurrentTs());
            rec = getNext() ;
        }

        this.setIter(lq.iterator());

    }

    public static void main (String [] args) {
        TestLinkedQueue tq = new TestLinkedQueue() ;
        tq.createQ();
        tq.printRecs();
        System.out.println( );
        tq.setFlag();
        tq.printRecs();
    }

    public Iterator<TestRecord> getIter() {
        return iter;
    }

    public void setIter(Iterator<TestRecord> iter) {
        this.iter = iter;
    }

    public synchronized  TestRecord getNext () {

        if (this.iter.hasNext())
            return iter.next() ;

        return null ;

    }
}
