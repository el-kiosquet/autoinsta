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
            writeDocument = new PrintWriter(new FileOutputStream(document, true));
            readDocument = new Scanner(this.document);
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found. Check permissions");
        }
    }

    /**
     * Checks if the file is empty
     * @return true if empty, false if it contains something.
     */
    public boolean isEmpty() {
        return !readDocument.hasNext();
    }

    /** Prints the hole document on the terminal */
    public void print() {
        for ( int i = 1; readDocument.hasNext(); i++ ) {
            System.out.print ( i + " -> " );
            System.out.println(readDocument.nextLine());
        }
    }
    
    /** Appends a given string to the file */
    public void append(String textToAdd) {
        writeDocument.println(textToAdd);
        writeDocument.flush();
    }

    public void removeLine(int n) {
        try {
            writeDocument.close();
            File temp = File.createTempFile("", ".temp");
            PrintWriter tempWriter = new PrintWriter(temp);
            for( int i = 1; readDocument.hasNext(); i++ ) {
                if( i != n ) tempWriter.println( readDocument.nextLine() );
            }
            writeDocument = new PrintWriter( new FileOutputStream( document )); // Overwrites document
            tempWriter.close();
            Scanner tempReader = new Scanner(temp);
            while( tempReader.hasNext() ) {
                writeDocument.println( tempReader.nextLine() );
            }
            tempReader.close();
            temp.delete();
            writeDocument.close();
            writeDocument = new PrintWriter(new FileOutputStream(document, true));
        }
        catch ( FileNotFoundException e ) { 
            System.err.println("ERROR: File not found. Check permissions");
        }
        catch ( IOException e ) {
            System.err.println("ERROR: Temporaly file could not be created. Check permissions");
        }
    }
}
