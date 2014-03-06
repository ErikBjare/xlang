package parser.expressions;

import parser.NameSpace;

/** Abstrakt klass som beskriver en nod i ett uttryckstr�d */
public abstract class Expr {

    /**
     * Evaluates expression (lazy evaluation)
     * @param ns Namespace to evaluate expression in
     * @return Value of expression
     */
    public abstract int value(NameSpace ns);

    public abstract String toString();
}
