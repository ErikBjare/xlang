package parser.expressions;

import parser.NameSpace;

public class Add extends Expr  {
	private Expr expr1, expr2;

	Add(Expr e1, Expr e2) {
        super(2);
		expr1 = e1;
		expr2 = e2;
	}

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
	public int value(NameSpace ns) {
		return expr1.value(ns) + expr2.value(ns);
	}

    @Override
    public String unparse(int prec) {
        String s = expr1.unparse(precedence-1) + "+" + expr2.unparse(precedence);
        if(prec > precedence) s = "(" + s + ")";
        return s;
    }
}
