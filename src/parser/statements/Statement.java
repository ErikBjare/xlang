package parser.statements;

import parser.NameSpace;

/**
 * Created by erb on 3/3/14.
 */
public abstract class Statement {

    /**
     * Executes statement
     * @param ns NameSpace to execute statement in
     */
    public abstract void execute(NameSpace ns);

    /**
     * Code-representation of the statement
     * @return code-equivalent of statement
     */
    public abstract String toString();

    protected static String indent(String str) {
        StringBuilder sb = new StringBuilder();
        String[] ss = str.split("\n");
        for(String s : ss) {
            sb.append("    ").append(s).append("\n");
        }
        return sb.toString();
    }
}
