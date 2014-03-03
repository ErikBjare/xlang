package parser.statements;

import parser.expressions.Expr;
import parser.NameSpace;
import parser.expressions.Var;

public class AssignStatement extends Statement {
    String name;
    Expr to_assign;

    public AssignStatement(String name, Expr to_assign) {
        this.name = name;
        this.to_assign = to_assign;
    }

    @Override
    public void execute(NameSpace ns) {
        if(ns.containsKey(name)) {
            ns.get(name).setValue(to_assign.value(ns), ns);
        } else {
            Var v = new Var(name, to_assign.value(ns));
            ns.put(name, v);
        }
    }
}
