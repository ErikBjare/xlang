package parser.expressions;

import parser.NameSpace;

public class Add extends Expr  {
	private Expr expr1, expr2;

	Add(Expr e1, Expr e2) {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(expr1);
        sb.append("+");
        sb.append(expr2);

        return sb.toString();
    }
}
