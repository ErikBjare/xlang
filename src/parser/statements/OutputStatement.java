package parser.statements;

import parser.expressions.Expr;
import parser.NameSpace;

public class OutputStatement extends Statement {
    Expr expr;
    String varname;

    public OutputStatement(Expr e) {
        this.expr = e;
    }

    /**
     * Executes statement
     * @param ns NameSpace to execute statement in
     */
    @Override
    public void execute(NameSpace ns) {
        System.out.println(Integer.toString(expr.value(ns)));
    }

    /**
     * Returns code-equivalent of the statement
     * @return Code-equivalent of statement
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("output ");
        if(expr != null) {
            sb.append(expr);
        } else {
            sb.append(varname);
        }
        return sb.toString();
    }
}
