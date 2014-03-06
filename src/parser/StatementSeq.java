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

    /**
     * Adds statement to StatementSeq
     * @param stmt Statement to add
     */
    public void add(Statement stmt) {
        seq.add(stmt);
    }

    /**
     * Prints code-equivalent of StatementSeq
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * Returns code-equivalent of StatementSeq
     * @return Code-equivalent of StatementSeq
     */
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

    /**
     * Executes statement-sequence in new NameSpace
     */
    public void execute() {
        execute(ns);

        System.out.println("\nNamespace at termination:");
        ns.print();
    }

    /**
     * Executes statement-sequence in given NameSpace
     * @param ns NameSpace to execute statement in
     */
    @Override
    public void execute(NameSpace ns) {
        for(Statement s : seq) {
            s.execute(ns);
        }
    }
}
