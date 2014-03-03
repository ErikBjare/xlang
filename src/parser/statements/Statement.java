package parser.statements;

import parser.NameSpace;

/**
 * Created by erb on 3/3/14.
 */
public abstract class Statement {

    public abstract void execute(NameSpace ns);
}
