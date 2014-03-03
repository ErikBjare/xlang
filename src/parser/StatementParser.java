package parser;

import parser.expressions.Expr;
import parser.expressions.ExprParser;
import parser.statements.*;

import java.io.StreamTokenizer;

/**
 * Created by erb on 3/3/14.
 */
public class StatementParser {
    private Tokenizer theTokenizer; // anv�nds f�r att h�mta token fr�n input
    private ExprParser exprParser;

    /** Konstruktor. Skapar en uttrycksparser knuten till en Tokenizer t */
    public StatementParser(Tokenizer t) {
        theTokenizer = t;
        exprParser = new ExprParser(t);
    }

    /** Returnerar ett uttryckstr�d som representerar det uttryck som parsras */
    public StatementSeq build() {
        return stmtSeq();
    }

    private StatementSeq stmtSeq() {
        StatementSeq seq = new StatementSeq();
        while(!theTokenizer.atEOF()) {
            seq.add(stmt());
            try {
                assert theTokenizer.ttype == ';';
            } catch(AssertionError e) {
                break;
                //System.err.println("Expected a ';' but instead ttype " + theTokenizer.ttype + " was found!\nExiting...");
                //throw e;
            }
            theTokenizer.next();
        }
        return seq;
    }

    private Statement stmt() {
        Statement stmt;
        assert theTokenizer.ttype == StreamTokenizer.TT_WORD;

        String word = theTokenizer.sval;
        if(word.equals("output")) {
            stmt = outputStmt();
        } else if(word.equals("if")) {
            stmt = ifStmt();
        } else if(word.equals("while")) {
            stmt = whileStmt();
        } else {
            stmt = assignStmt(word);
        }

        return stmt;
    }

    private AssignStatement assignStmt(String name) {
        theTokenizer.next();
        assert theTokenizer.ttype == '=';
        theTokenizer.next();
        return new AssignStatement(name, exprParser.build());
    }

    private OutputStatement outputStmt() {
        theTokenizer.next();
        //System.out.println(theTokenizer.ttype);
        //System.out.println(theTokenizer.sval);
        if(theTokenizer.ttype == Tokenizer.TT_WORD) {
            String name = theTokenizer.sval;
            theTokenizer.next();
            return new OutputStatement(name);
        } else {
            return new OutputStatement(exprParser.build());
        }
    }

    private IfStatement ifStmt() {
        // If-statement
        theTokenizer.next();
        Expr condition = exprParser.build();
        assert theTokenizer.sval.equals("then");
        theTokenizer.next();
        StatementSeq ifStmtSeq = stmtSeq();
        assert theTokenizer.sval.equals("else");
        theTokenizer.next();
        StatementSeq elseStmtSeq = stmtSeq();
        assert theTokenizer.sval.equals("endif");
        theTokenizer.next();
        return new IfStatement(condition, ifStmtSeq, elseStmtSeq);
    }

    private WhileStatement whileStmt() {
        // While-statement
        theTokenizer.next();
        Expr condition = exprParser.build();
        assert theTokenizer.sval.equals("do");
        theTokenizer.next();
        StatementSeq stmtSeq = stmtSeq();
        assert theTokenizer.sval.equals("done");
        theTokenizer.next();
        return new WhileStatement(condition, stmtSeq);
    }

}
