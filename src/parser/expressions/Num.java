package parser.expressions;

import parser.NameSpace;

public class Num extends Expr {
	private int value;

	public Num(int v) {
        super(255);
		value = v;
	}

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
	public int value(NameSpace ns) {
		return value;
	}

    @Override
    public String unparse(int prec) {
        return toString();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
