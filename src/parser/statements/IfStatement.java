package parser.statements;

import parser.expressions.Expr;
import parser.NameSpace;
import parser.StatementSeq;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if ")
                .append(condition)
                .append(" do\n")
                .append(indent(ifStmtSeq.toString()))
                .append("else\n")
                .append(indent(elseStmtSeq.toString()))
                .append("endif");
        return sb.toString();
    }
}
