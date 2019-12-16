
public class GenerateChar {

    double []  pValue ;
    double [] cpValue ;
    char [] charArr ;
    private int loop = 0 ;

    public GenerateChar () {
        generateTestData();
    }

    public void generateTestData ()  {
        int numChars = (int) (Math.random()  * 255) ;
        while (numChars <= 1)
            numChars = (int) (Math.random()  * 26) ;
        charArr = new char[numChars] ;
        for (int i = 0 ; i < numChars ; i++) {
            charArr [i] = (char) (i );
        }
        double curProb = 0.0 ;
        pValue = new double[numChars] ;
        double probvalue = 1.0 / (double)  numChars ;
        for (int i = 0 ; i < numChars  ; i++) {
            //pValue[i] = Math.random() * (1.0 - curProb) ;
            pValue[i] = probvalue ;
            curProb += pValue[i] ;
        }

       // System.out.println(curProb) ;
        cpValue = new double[numChars] ;
        for (int i = 0 ; i < numChars ; i++) {
            if (i == 0) {
                cpValue[i] = pValue[i] ;
            }
            else {
                cpValue[i] = cpValue[i-1] + pValue[i] ;
            }
        }
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public int findInd (double value) {
        int low = 0 ;
        int high = cpValue.length - 1 ;
        int mid = (high -low) / 2 ;
        setLoop(0);

        while (low < high) {
            if (cpValue [mid] == value) return mid ;
            if (high - low == 1) {
                if (cpValue [low] >= value) return low  ;
                return high ;
            }
            if (cpValue[mid] < value) {
                low = mid ;
                mid = (high - low) /2 + low ;
            }
            else {
                high = mid ;
                mid = (high -low) / 2 + low ;
            }
            loop++ ;
        }
        if (cpValue [low] >= value) return low  ;
        return high ;
    }

    public double[] getpValue() {
        return pValue;
    }

    public void setpValue(double[] pValue) {
        this.pValue = pValue;
    }

    public double[] getCpValue() {
        return cpValue;
    }

    public void setCpValue(double[] cpValue) {
        this.cpValue = cpValue;
    }

    public char[] getCharArr() {
        return charArr;
    }

    public void setCharArr(char[] charArr) {
        this.charArr = charArr;
    }

    public static void main(String[] args) {
        GenerateChar gc = new GenerateChar() ;
        double value = Math.random() ;
        int ind = gc.findInd(value) ;
        System.out.println ("The random value came out as = " + value ) ;
        System.out.println("The index of the selected char is "  + ind );
        if (ind > 0) {
            System.out.println("The value of cumulative probability current and prior are " + gc.getCpValue()[ind] + "\t" + gc.getCpValue()[ind - 1]) ;
        }
        else {
            System.out.println("The value of cumulative probablility at 0th index is " + gc.getCpValue()[ind]);
        }
        System.out.println("The size of array is = " + gc.getCharArr().length +
                ", and the number of steps to select took = " + gc.getLoop() + " steps");
    }
}

