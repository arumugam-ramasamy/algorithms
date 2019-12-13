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
		Thread.sleep(5) ;
	    }
	}
	catch (InterruptedException e) {
	}
	catch (IOException e) {
	}

  // create instance of Random class 
        Random rand = new Random(); 
  
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(1000); 
        int rand_int2 = rand.nextInt(1000); 
  
        // Print random integers 
        System.out.println("Random Integers: "+rand_int1); 
        System.out.println("Random Integers: "+rand_int2); 
  
        // Generate Random doubles 
        double rand_dub1 = rand.nextDouble(); 
        double rand_dub2 = rand.nextDouble(); 
  
        // Print random doubles 
        System.out.println("Random Doubles: "+rand_dub1); 
        System.out.println("Random Doubles: "+rand_dub2); 
    } 
} 
