package parser.statements;

import parser.NameSpace;

/**
 * Created by erb on 3/3/14.
 */
public abstract class Statement {

    public abstract void execute(NameSpace ns);

    public abstract String toString();

    public static String indent(String str) {
        StringBuilder sb = new StringBuilder();
        String[] ss = str.split("\n");
        for(String s : ss) {
            sb.append("    ").append(s).append("\n");
        }
        return sb.toString();
    }
}
