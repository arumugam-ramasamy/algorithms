import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Unit;

public class ExprTest {
    public static  Logger logger = LoggerFactory.getLogger("APP") ;
    static Unit unit ;

    private Object expr(String expression) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entered expr tree");
        }
        /*ParseTree parseTree = ExpressionUtils.createParseTree(expression);
        return new ExprSIVisitor()
                .visit(parseTree);*/
        return null ;
    }

    public String transform(String inputunits) {

        inputunits = inputunits.replaceAll("minute", "1") ;
        inputunits = inputunits.replaceAll("hour", "2") ;
        inputunits = inputunits.replaceAll("day", "3") ;
        inputunits = inputunits.replaceAll("degree", "4") ;
        inputunits = inputunits.replaceAll("arcminute", "5") ;
        inputunits = inputunits.replaceAll("arcsecond", "6") ;
        inputunits = inputunits.replaceAll("hectare", "7") ;
        inputunits = inputunits.replaceAll("litre", "8") ;
        inputunits = inputunits.replaceAll("tonne", "9") ;
        inputunits = inputunits.replaceAll("min", "1") ;
        inputunits = inputunits.replaceAll("h", "2") ;
        inputunits = inputunits.replaceAll("d", "3") ;
        inputunits = inputunits.replaceAll("'", "5") ;
        inputunits = inputunits.replaceAll("\"", "6") ;
        inputunits = inputunits.replaceAll("ha", "7") ;
        inputunits = inputunits.replaceAll("L", "8") ;
        inputunits = inputunits.replaceAll("t", "9") ;
        return  inputunits ;
    }

    public static void main(String[] args) {
        ExprTest eTest = new ExprTest() ;
        logger.debug(" Came to main");
        //eTest.expr("(degree/(minute*hectare)*(hectare*litre))") ;
        String transformed =  eTest.transform(args[0]) ;
        System.out.println(transformed);
        eTest.expr(transformed) ;
    }
}


