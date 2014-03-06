package parser;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		if (args.length==0) {
            run_interactive();
		} else {
            run_file(args[0]);
        }
	}

    /**
     * Enables the user to enter a program manually or by piping to the stdin
     */
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

    /**
     * Runs a program from file
     */
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
        stmtSeq.print();
        stmtSeq.execute();

    }
}
