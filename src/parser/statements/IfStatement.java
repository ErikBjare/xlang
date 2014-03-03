package parser.statements;

import parser.expressions.Expr;
import parser.NameSpace;
import parser.StatementSeq;

/**
 * Created by erb on 3/3/14.
 */
public class IfStatement extends Statement {
    Expr condition;
    StatementSeq ifStmtSeq;
    StatementSeq elseStmtSeq;

    public IfStatement(Expr condition, StatementSeq ifStmtSeq, StatementSeq elseStmtSeq) {
        this.condition = condition;
        this.ifStmtSeq = ifStmtSeq;
        this.elseStmtSeq = elseStmtSeq;
    }

    @Override
    public void execute(NameSpace ns) {
        if(condition.value(ns) != 0) {
            ifStmtSeq.execute(ns);
        } else {
            elseStmtSeq.execute(ns);
        }
    }
}
