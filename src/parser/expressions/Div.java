package parser.expressions;

import parser.NameSpace;

public class Div extends Expr {
	private Expr expr1, expr2;
	
	Div(Expr e1, Expr e2) {
        super(4);
		expr1 = e1;
		expr2 = e2;
	}

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
	public int value(NameSpace ns) {
		return expr1.value(ns) / expr2.value(ns);
	}

    @Override
    public String toString() {
        return toStringPrecedence("/", expr1, expr2);
    }
}
