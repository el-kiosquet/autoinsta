package code;

import java.io.*;
import java.util.InputMismatchException;
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

    static Scanner kbd = autoinsta.kbd; //Uses same Scanner as in the main class
    /** This method prints the selected configuration file
     * and lets the user modify it
     * @param isJustOne True if there can only be 1 element (e.g. downloaderUsername)
     */
    public void editDocument( boolean isJustOne ) {
        if ( this.isEmpty() ) {
            System.out.println( "Still not any data configured!" + "\n" +
                                "Please input data:");
            String input = kbd.nextLine();
            this.append( input );
            System.out.println(input + " added");
            if(! isJustOne) editDocument(isJustOne);
        } else {
            System.out.println("Data stored:");
            this.print();
            if(! isJustOne) System.out.println("Input text to add it");
            System.out.println( "Input a line number to delete it" + "/n" + 
                                "Input 0 to exit");
            kbd.hasNext();
            if (kbd.hasNextInt()) {
                if (kbd.nextInt() != 0) this.removeLine(kbd.nextInt());
                kbd.nextLine();
            } else {
                if (isJustOne) {
                    System.err.println("Only integers are admited");
                } else {
                    this.append(kbd.nextLine());
                }
            }
            
        }
    }
}
