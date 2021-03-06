package edu.lmu.cs.xlg.yoda.entities;

import java.util.List;

import edu.lmu.cs.xlg.util.Log;

/**
 * An array expression, such as [3.50, 9, -6], or [].  The type of the array expression is
 * computed at semantic analysis time as the type of arrays of its most general element.
 */
public class ArrayConstructor extends Expression {

    private List<Expression> expressions;

    public ArrayConstructor(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {

        // First analyze the subexpressions
        for (Expression e: expressions) {
            e.analyze(log, table, owner, inLoop);
        }
    }
}
