package edu.lmu.cs.xlg.yoda.entities;

import edu.lmu.cs.xlg.util.Log;


public class WhileLoop extends Statement {

    private Expression condition;
    private Block body;

    public WhileLoop(Expression condition, Block body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {
        condition.analyze(log, table, owner, inLoop);
        body.analyze(log, table, owner, true);
    }
}
