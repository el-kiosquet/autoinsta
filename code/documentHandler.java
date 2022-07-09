package code;

import java.io.*;
import java.util.Scanner;

public class documentHandler {
    File document = null;
    PrintWriter writeDocument = null;
    Scanner readDocument = null;

    public documentHandler(String documentRute) {
        try {
            document = new File(documentRute);
            writeDocument = new PrintWriter(document);
            readDocument = new Scanner(this.document);
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found. Check permissions");
        }
    }

    /** Prints the hole document on the terminal */
    public void print() {
        while (readDocument.hasNext()) System.out.println(readDocument.next());
        readDocument.close();
    }
    
    /** Appends a given string to the file */
    public void append(String textToAdd) {
        writeDocument.println(textToAdd);
    }
}
