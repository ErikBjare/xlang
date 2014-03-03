package parser;

import parser.statements.Statement;

import java.util.ArrayList;

/**
 * Created by erb on 3/3/14.
 */
public class StatementSeq extends Statement {
    ArrayList<Statement> seq;
    NameSpace ns;

    public StatementSeq() {
        seq = new ArrayList<Statement>();
        ns = new NameSpace();
    }

    public void add(Statement stmt) {
        seq.add(stmt);
    }

    public void execute() {
        execute(ns);
    }

    public void execute(Statement stmt) {
        stmt.execute(ns);
    }

    @Override
    public void execute(NameSpace ns) {
        for(Statement s : seq) {
            s.execute(ns);
        }
    }
}
