package utils;

import antlr4.ExprBaseListener;
import antlr4.ExprBaseVisitor;
import antlr4.ExprParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExprSIVisitor extends ExprBaseVisitor<Long> {

    Logger logger = LoggerFactory.getLogger(ExprSIVisitor.class) ;

    @Override
    public Long visitInt(ExprParser.IntContext ctx) {
        return Long.valueOf(ctx.INT().getText());
    }

    @Override
    public Long visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Long visitArithmetic(ExprParser.ArithmeticContext ctx) {
        Long left = visit(ctx.expr(0));
        Long right = visit(ctx.expr(1));

        switch (ctx.op.getType()) {
            case ExprParser.OP_MUL:
                if (logger.isDebugEnabled()) {
                    logger.debug(" Came to *");
                }
                return left * right;
            case ExprParser.OP_DIV:
                if (logger.isDebugEnabled()) {
                    logger.debug(" Came to /");
                }
                System.out.println ("came here /") ;
                return left / right;
            default:
                throw new IllegalStateException("Unknown operator " + ctx.op);
        }
    }

}
