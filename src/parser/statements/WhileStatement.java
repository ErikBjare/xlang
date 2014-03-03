package parser.statements;

import parser.NameSpace;
import parser.StatementSeq;
import parser.expressions.Expr;

/**
 * Created by erb on 3/3/14.
 */
public class WhileStatement extends Statement {
    Expr condition;
    StatementSeq stmtSeq;

    public WhileStatement(Expr condition, StatementSeq stmtSeq) {
        this.condition = condition;
        this.stmtSeq = stmtSeq;
    }

    @Override
    public void execute(NameSpace ns) {
        while(condition.value(ns) != 0) {
            stmtSeq.execute(ns);
        }
    }
}
