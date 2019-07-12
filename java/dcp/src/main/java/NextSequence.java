import java.net.Authenticator;
import java.util.concurrent.atomic.AtomicInteger;

public class NextSequence {

    private static AtomicInteger count = new AtomicInteger(0) ;

    public static Integer nextSeq () {
        count.addAndGet(1) ;
        return count.get() ;
    }
}
