import java.util.Random;
import java.io.* ;
  
public class Rand{ 
  
    public static void main(String args[]) 
    {
	BufferedWriter out = null ;
	try {
	    out = new BufferedWriter(new FileWriter("random.log"));
	    Random rand = new Random();
	    while (true) {
		int rand1 = rand.nextInt(1000); 
		int rand2 = rand.nextInt(1000); 
		int rand3 = rand.nextInt(1000); 
		int rand4 = rand.nextInt(1000); 
		int rand5 = rand.nextInt(1000); 
		int rand6 = rand.nextInt(1000); 
		int rand7 = rand.nextInt(1000); 
		int rand8 = rand.nextInt(1000); 
		int rand9 = rand.nextInt(1000); 
		out.write(rand1 + "," + rand2 + "," + rand3 + "," + rand4 + "," + rand5 + "," + rand6 +
			  "," + rand7 + "," + rand8 + "," + rand9 + "\n");
		//Thread.sleep(3000) ;
		TimeUnit.SECONDS.sleep(3);
	    }
	}
	catch (InterruptedException e) {
	}
	catch (IOException e) {
	}

    } 
} 
