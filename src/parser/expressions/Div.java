package parser.expressions;

import parser.NameSpace;

public class Div extends Expr {
	private Expr expr1, expr2;
	
	Div(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	public int value(NameSpace np) {
		return expr1.value(np) / expr2.value(np);
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
