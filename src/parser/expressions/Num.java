package parser.expressions;

import parser.NameSpace;

public class Num extends Expr {
	private int value;

	public Num(int v) {
		value = v;
	}

	public int value(NameSpace np) {
		return value;
	}
}
