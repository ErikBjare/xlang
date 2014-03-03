package parser.expressions;

import parser.NameSpace;

public class Add extends Expr  {
	private Expr expr1, expr2;

	Add(Expr e1, Expr e2) {
		expr1 = e1;
		expr2 = e2;
	}

	public int value(NameSpace np) {
		return expr1.value(np) + expr2.value(np);
	}
}
