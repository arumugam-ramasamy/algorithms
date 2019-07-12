import java.util.Iterator;

public class TestRecord {

    int number ;
    Long currentTs ;
    Boolean processed ;
    int partitionNumber ;

    public TestRecord  () {
        number = -1 ;
        currentTs = System.currentTimeMillis() ;
        processed = false ;
    }

    public TestRecord (int number, int partition) {
        this.number = number ;
        this.currentTs = System.currentTimeMillis() ;
        processed = false ;
        this.partitionNumber = partition ;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getCurrentTs() {
        return currentTs;
    }

    public void setCurrentTs(Long currentTs) {
        this.currentTs = currentTs;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public int getPartitionNumber() {
        return partitionNumber;
    }

    public void setPartitionNumber(int partitionNumber) {
        this.partitionNumber = partitionNumber;
    }
}
