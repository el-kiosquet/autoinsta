package code;

public class instaloaderHandler {
    public static void downloaderUser() {
        documentHandler downloaderUser = new documentHandler("config\\instaloader\\downloaderUsername.txt");
        if (downloaderUser.isEmpty()) {
            System.out.println("Still not any username configured!");
        } else {
            downloaderUser.print();
        }
    }
}
