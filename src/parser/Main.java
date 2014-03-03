package parser;

import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;
import parser.expressions.Expr;
import parser.expressions.ExprParser;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		Reader reader = null;
		if (args.length==0) {
            run_interactive();
		} else {
            run_file(args[0]);
        }
	}

    public static void run_interactive() {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        String nextLine;
        do {
            System.out.print(">>> ");
            nextLine = scan.nextLine();
            sb.append(nextLine);
        } while(nextLine.length() != 0);

        Reader reader = new StringReader(sb.toString());
        Tokenizer theTokenizer = new Tokenizer(reader);
        theTokenizer.next();
        StatementParser parser = new StatementParser(theTokenizer);
        StatementSeq stmtSeq = parser.build();
        stmtSeq.execute();
    }

    public static void run_file(String filepath) {
        Reader reader = null;
        try {
            reader = new FileReader(filepath);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Tokenizer theTokenizer = new Tokenizer(reader);
        theTokenizer.next();
        StatementParser parser = new StatementParser(theTokenizer);
        StatementSeq stmtSeq = parser.build();
        stmtSeq.execute();
    }
}
