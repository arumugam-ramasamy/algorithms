import java.util.concurrent.*;

public class DemoExecutor
{
    public static void main(String[] args)
    {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);

        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
                20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
        BlockingQueue<String> messages = new ArrayBlockingQueue<String>(50) ;

        ProducerThread producer1 = new ProducerThread() ;
        producer1.setMessages(messages);
        ProducerThread producer2 = new ProducerThread() ;
        producer1.setMessages(messages);
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                                          ThreadPoolExecutor executor) {
                System.out.println("DemoTask Rejected : "
                        + ((DemoTask) r).getName());
                System.out.println("Waiting for a second !!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lets add another time : "
                        + ((DemoTask) r).getName());
                executor.execute(r);
            }
        });
        // Let start all core threads initially
        executor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            DemoTask task  = new DemoTask(threadCounter.toString()) ;
            task.setMessages(messages);
            executor.execute(task);
            if (threadCounter % 5 == 0) {
                producer1.run();
                producer2.run();
            }
            if (threadCounter == 100)
                break;
        }
    }

}

