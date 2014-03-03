package parser;

import parser.statements.Statement;

import java.util.ArrayList;

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

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < seq.size()-1) {
            sb.append(seq.get(i));
            sb.append(";\n");
            i++;
        }
        sb.append(seq.get(seq.size() - 1));
        sb.append("\n");
        return sb.toString();
    }

    public void execute() {
        execute(ns);

        System.out.println("\nNamespace at termination:");
        ns.print();
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
