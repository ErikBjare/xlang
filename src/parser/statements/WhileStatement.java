package parser.statements;

import parser.NameSpace;
import parser.StatementSeq;
import parser.expressions.Expr;

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

    @Override
    public String toString() {
        return "while " + condition + " do\n" + indent(stmtSeq.toString()) + "done";
    }
}
