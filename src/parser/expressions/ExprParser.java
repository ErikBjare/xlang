package parser.expressions;

import parser.Tokenizer;

public class ExprParser {
	private Tokenizer theTokenizer; // anv�nds f�r att h�mta token fr�n input

	/** Konstruktor. Skapar en uttrycksparser knuten till en Tokenizer t */
	public ExprParser(Tokenizer t) {
		theTokenizer = t;
	}

	/** Returnerar ett uttryckstr�d som representerar det uttryck som parsras */
	public Expr build() {
		return expr();
	}

	/* Metod som motsvarar startproduktionen */
	private Expr expr() {
		Expr res, nextTerm;	res = term();
		while (theTokenizer.ttype == '+' || theTokenizer.ttype == '-') {
			char op = (char) theTokenizer.ttype;
			theTokenizer.next();
			nextTerm = term();
			if (op == '+') {
				res = new Add(res,nextTerm);
			} else {
				res = new Sub(res,nextTerm);
			}
		}
		return res;
	}
	
	/* Metod motsvarande term-produktionen */
	private Expr term() {
		Expr res, nextFactor;
		res = factor();
		while (theTokenizer.ttype == '*' || theTokenizer.ttype == '/') {
			char op = (char) theTokenizer.ttype;
			theTokenizer.next();
			nextFactor = factor();
			if (op == '*') {
				res = new Mult(res, nextFactor);
			} else {
				res = new Div(res, nextFactor);
			}
		}
		return res;
	}
	
	/* Metod motsvarande factor-produktionen. */
	private Expr factor() {
		if (theTokenizer.ttype == '(') {
			theTokenizer.next();
			Expr exp = expr();
			theTokenizer.accept(')');
			return exp;
		} else if (theTokenizer.ttype == Tokenizer.TT_NUMBER) {
			int x = (int) theTokenizer.nval;
			theTokenizer.next();
			return new Num(x);
        } else if (theTokenizer.ttype == Tokenizer.TT_WORD) {
            String name = theTokenizer.sval;
            theTokenizer.next();
            return new Var(name, 0);
		} else {
			throw new RuntimeException("\nExprParser.factor: found:  " + theTokenizer.found());
		}
	}
}
