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

    /**
     * Executes statement
     * @param ns NameSpace to execute statement in
     */
    @Override
    public void execute(NameSpace ns) {
        while(condition.value(ns) != 0) {
            stmtSeq.execute(ns);
        }
    }

    /**
     * Code-representation of the statement
     * @return code-equivalent of statement
     */
    @Override
    public String toString() {
        return "while " + condition + " do\n" + indent(stmtSeq.toString()) + "done";
    }
}
