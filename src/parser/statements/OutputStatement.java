package parser.statements;

import parser.expressions.Expr;
import parser.NameSpace;

public class OutputStatement extends Statement {
    Expr expr;
    String varname;

    public OutputStatement(Expr e) {
        this.expr = e;
    }

    public OutputStatement(String varname) {
        this.varname = varname;
    }

    @Override
    public void execute(NameSpace ns) {
        if(expr != null) {
            System.out.println(Integer.toString(expr.value(ns)));
        } else {
            System.out.println(ns.get(varname).value(ns));
        }
    }
}