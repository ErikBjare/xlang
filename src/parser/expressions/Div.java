package parser.expressions;

import parser.NameSpace;

public class Div extends Expr {
	private Expr expr1, expr2;
	
	Div(Expr e1, Expr e2) {
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
        StringBuilder sb = new StringBuilder();

        if(expr1 instanceof Add || expr1 instanceof Sub) sb.append("(").append(expr1).append(")");
        else sb.append(expr1);
        sb.append("/");
        if(expr2 instanceof Add || expr2 instanceof Sub) sb.append("(").append(expr2).append(")");
        else sb.append(expr2);

        return sb.toString();
    }
}
