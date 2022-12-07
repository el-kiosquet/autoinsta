package code;

import java.util.Scanner;

public class instaloaderHandler {
    static Scanner kbd = autoinsta.kbd;
    public static void downloaderUser() {
        documentHandler downloaderUser = new documentHandler("config\\instaloader\\downloaderUsername.txt");
        if (downloaderUser.isEmpty()) {
            System.out.println( "Still not any username configured!" + "\n" +
                                "Please input your instagram username:");
            String input = kbd.nextLine();
            downloaderUser.append( input );
        } else {
            downloaderUser.print();
        }
    }
    public static void flags() {
        documentHandler flags = new documentHandler("config\\instaloader\\flags.txt");
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
                flags();
            }
        }
    }
}
