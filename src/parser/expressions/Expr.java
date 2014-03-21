package parser.expressions;

import parser.NameSpace;

/** Abstrakt klass som beskriver en nod i ett uttryckstr�d */
public abstract class Expr {
    public int precedence;

    public Expr(int precedence) {
        this.precedence = precedence;
    }

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
    public abstract int value(NameSpace ns);

    public abstract String unparse(int prec);

    public String toString() {
        return unparse(0);
    }
}
