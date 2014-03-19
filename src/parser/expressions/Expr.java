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

    public abstract String toString();

    protected String toStringPrecedence(String op, Expr expr1, Expr expr2) {
        StringBuilder sb = new StringBuilder();

        //System.out.println(expr1.precedence + " " + precedence + " " + expr2.precedence);
        if (expr1.precedence < precedence) {
            sb.append("(").append(expr1).append(")");
        } else {
            sb.append(expr1);
        }
        sb.append(op);
        if (expr2.precedence < precedence) {
            sb.append("(").append(expr2).append(")");
        } else {
            sb.append(expr2);
        }
        return sb.toString();
    }
}
