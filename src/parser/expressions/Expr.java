package parser.expressions;

import parser.NameSpace;

/** Abstrakt klass som beskriver en nod i ett uttryckstr�d */
public abstract class Expr {	
		/** Ber�kna v�rdet av uttrycket
         * @param np*/
		public abstract int value(NameSpace np);
}
