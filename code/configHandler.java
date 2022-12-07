package code;

import java.util.Scanner;

public class configHandler {
    static Scanner kbd = autoinsta.kbd; //Uses same Scanner as in the main class

    /** @param rute Rute to document */
    public static void downloaderUser( String rute ) {
        documentHandler downloaderUser = new documentHandler( rute );
        if (downloaderUser.isEmpty()) {
            System.out.println( "Still not any username configured!" + "\n" +
                                "Please input your instagram username:");
            String input = kbd.nextLine();
            downloaderUser.append( input );
        } else {
            downloaderUser.print();
        }
    }
    /** @param rute Rute to document */
    public static void flags( String rute ) {
        documentHandler flags = new documentHandler( rute );
        if (flags.isEmpty()) {
            System.out.println( "Still not any flag added!" + "\n" +
                                "Please input 1 flag at a time");
            String input = kbd.nextLine();
            flags.append( input );
        } else {
            flags.print();
            System.out.println("To add new flags input them one at a time" + "\n" + 
                                "To exit press 0");
            String input = kbd.nextLine();
            if( ! input.equals("0") ) {
                flags.append(input);
                flags( rute );
            }
        }
    }
    public static void targets() {
        documentHandler targets = new documentHandler( "config\\instaloader\\targets.txt" );
        if (targets.isEmpty()) {
            System.out.println( "Still not any target added!" + "\n" +
                                "Please input 1 target at a time");
            String input = kbd.nextLine();
            targets.append( input );
        } else {
            targets.print();
            System.out.println("To add new targets input them one at a time" + "\n" + 
                                "To exit press 0");
            String input = kbd.nextLine();
            if( ! input.equals("0") ) {
                targets.append(input);
                targets();
            }
        }
    }
}
