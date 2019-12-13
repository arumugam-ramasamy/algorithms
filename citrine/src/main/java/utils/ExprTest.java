package utils;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExprTest {
    public static  Logger logger = LoggerFactory.getLogger("APP") ;
    static Unit unit = new Unit() ;

    private Object expr(String expression) {
        if (logger.isDebugEnabled()) {
            logger.debug("Entered expr tree");
        }
        ParseTree parseTree = ExprUtils.createParseTree(expression);
        return new ExprSIVisitor()
                .visit(parseTree);
        //return null ;
    }

    public String transform(String inputunits) {

        inputunits = inputunits.replaceAll("minute", GrammarConstants.getMINUTEString()) ;
        inputunits = inputunits.replaceAll("hour", GrammarConstants.getHOURString()) ;
        inputunits = inputunits.replaceAll("day", GrammarConstants.getDAYString()) ;
        inputunits = inputunits.replaceAll("degree", GrammarConstants.getDEGREEString()) ;
        inputunits = inputunits.replaceAll("arcminute", GrammarConstants.getARCMINUTEString()) ;
        inputunits = inputunits.replaceAll("arcsecond", GrammarConstants.getARCSECONDString()) ;
        inputunits = inputunits.replaceAll("hectare", GrammarConstants.getHECTAREString()) ;
        inputunits = inputunits.replaceAll("litre", GrammarConstants.getLITREString()) ;
        inputunits = inputunits.replaceAll("tonne", GrammarConstants.getTONNEString()) ;
        inputunits = inputunits.replaceAll("min", GrammarConstants.getMINUTEString()) ;
        inputunits = inputunits.replaceAll("h", GrammarConstants.getHOURString()) ;
        inputunits = inputunits.replaceAll("d", GrammarConstants.getDAYString()) ;
        inputunits = inputunits.replaceAll("'", GrammarConstants.getARCMINUTEString()) ;
        inputunits = inputunits.replaceAll("\"", GrammarConstants.getARCSECONDString()) ;
        inputunits = inputunits.replaceAll("ha", GrammarConstants.getHECTAREString()) ;
        inputunits = inputunits.replaceAll("L", GrammarConstants.getLITREString()) ;
        inputunits = inputunits.replaceAll("t", GrammarConstants.getTONNEString()) ;
        return  inputunits ;
    }

    public static void main(String[] args) {
        ExprTest eTest = new ExprTest() ;
        logger.debug(" Came to main");
        //eTest.expr("(degree/(minute*hectare)*(hectare*litre))") ;
        String transformed =  eTest.transform(args[0]) ;
        System.out.println(transformed);
        eTest.expr(transformed) ;
        ParseTree parseTree = ExprUtils.createParseTree(transformed);
        Object expr = new ExprSIVisitor().visit(parseTree) ;
        unit.printUnits();
    }
}


