package parser.expressions;

import parser.NameSpace;

/**
 * Created by erb on 3/3/14.
 */
public class Var extends Expr {
    String name;
    int val;

    public Var(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public Var(String name) {
        this.name = name;
    }

    public void setValue(int val, NameSpace ns) {
        ns.get(name).val = val;
    }

    @Override
    public int value(NameSpace ns) {
        return ns.get(name).val;
    }

    @Override
    public String toString() {
        return name;
    }
}
