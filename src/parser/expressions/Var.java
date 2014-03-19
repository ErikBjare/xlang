package parser.expressions;

import parser.NameSpace;

/**
 * Created by erb on 3/3/14.
 */
public class Var extends Expr {
    String name;
    int val;

    public Var(String name, int val) {
        super(255);
        this.name = name;
        this.val = val;
    }

    public Var(String name) {
        super(255);
        this.name = name;
    }

    public void setValue(int val, NameSpace ns) {
        ns.get(name).val = val;
    }

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
    @Override
    public int value(NameSpace ns) {
        return ns.get(name).val;
    }

    @Override
    public String toString() {
        return name;
    }
}
