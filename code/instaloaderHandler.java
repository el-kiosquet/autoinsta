package code;

import java.util.Scanner;

public class instaloaderHandler {
    public static void downloaderUser(Scanner kbd) {
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
}
