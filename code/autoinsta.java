package code;

/**
 * autoinsta
 */

 import java.util.*;

public class autoinsta {

    
    static Scanner kbd = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to autoinsta");
        menuEditOrRun();

    }

    public static void menuEditOrRun() {
        String[] editOrRun = {"", "Edit", "Run"};
        switch (menu(editOrRun)) {
            case 1: menuSelectProgramToEdit(); break;
            case 2: //TODO: Run program 
                break;
            
            default:
                System.err.println("Unnexpected error. If you see this message post a bug report");
                break;
        }
    }
    public static void menuSelectProgramToEdit() {
        String[] SelectProgramToEdit = {"",
                                        "Edit instaloader configuration",
                                        "Edit rclone configuration",
                                        "Edit autoinsta configuration"};
        switch (menu(SelectProgramToEdit)) {
            case 1: menuEditInstaloader(); break;
            case 2: menuEditRclone(); break;
            case 3: menuEditAutoinsta(); break;
            default:
                System.err.println("Unnexpected error. If you see this message post a bug report");
                break;
        }
    }

    public static void menuEditInstaloader() {
        String[] editInstaloader = {"",
                                    "Add/View downloader username and/or password",
                                    "Add/View targets",
                                    "Add/View flags"};
        switch (menu(editInstaloader)) {
            case 1: configHandler.downloaderUser("config\\instaloader\\downloaderUsername.txt"); break;
            case 2: configHandler.targets(); break;
            case 3: configHandler.flags("config\\instaloader\\flags.txt"); break;
            
            default:
                System.err.println("Unexpected error. If you see this message post a bug report");
                break;
        }
    }

    public static void menuEditRclone() {
        String[] editRclone = { "",
                                "Add/View username and/or password",
                                "Configure",
                                "Add/View flags"};
        switch (menu(editRclone)) {
            case 1: break;
            case 2: break;
            case 3: break;
            
            default:
                System.err.println("Unnexpected error. If you see this message post a bug report");
                break;
        }
    }

    public static void menuEditAutoinsta() {
        String[] editAutoinsta = {  "",
                                    "Select remote storage",};
        switch (menu(editAutoinsta)) {
            case 1: break;
            
            default:
                System.err.println("Unnexpected error. If you see this message post a bug report");
                break;
        }
    }

    /* public static void menuSelectProgramToEdit(Scanner kbd) {
        String[] SelectProgramToEdit = {"", "", ""};
        switch (menu(SelectProgramToEdit, kbd)) {
            case 1: break;
            case 2: break;
            
            default:
                System.err.println("Unnexpected error. If you see this message post a bug report");
                break;
        }
    } */

    /** This method creates a menu with the options from 
     * the array given as the parameter and returns the 
     * selected option.
     * 
     * @param options An array of type string which contains
     * the options to be displayed starting by position 1.
     * @param kbd An object of the class scanner.
     * @return Returns the selected option corresponding
     * to their position on the array.
     */
    public static int menu( String[] options ) {
        while (true) {
            try {
                System.out.println("Please select a valid option from 0 to " + (options.length - 1) );
                System.out.println("0: Quit script");
                for (int i = 1; i < options.length; i++) {
                    System.out.printf("%d: %s" + "\n", i, options[i]);
                }
                int in = kbd.nextInt();
                kbd.nextLine();
                if (in >= 0 && in < options.length) {
                    if (in == 0) {
                        System.out.print("Bye!");
                        System.exit(0);
                    }
                    return in;
                }
            } catch (InputMismatchException e) {
                kbd.next();
                System.err.println("Only integers are admited!");
            }
        }
    }
}