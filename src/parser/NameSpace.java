package parser;

import parser.expressions.Var;

import java.util.Collections;
import java.util.HashMap;

public class NameSpace extends HashMap<String, Var> {
    public NameSpace() {
        super();
    }

    /**
     * Prints contents of namespace
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(String s : keySet()) {
            sb.append(s);
            sb.append("=");
            sb.append(get(s).value(this));
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("}");
        System.out.println(sb.toString());
    }
}
