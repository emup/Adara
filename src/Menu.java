import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu extends Main {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    protected static final Scanner scanner = new Scanner(System.in);

    private static final ArrayList<String> mainMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Hoofdmenu" + ANSI_RESET,
            "1: Kisten",
            "2: Bestellingen",
            "3: Klanten",
            "0: Sluit programma\n"
    ));

    public Menu(){
        mainMenu();
    }

    public static void mainMenu(){
        while(checkSelected()) {
            for(String m : mainMenu) {
                System.out.println(m);
            }

            switch (scanSelectedInt()) {
                case 1:
                    KistenMenu.showKistenMenu();
                case 2:
                    OrderMenu.showOrderMenu();
                case 3:
                    CustomerMenu.showCustomerMenu();
                case 0:
                    System.exit(0);
                default:
                    showInvalidInputMessage();
            }
        }
    }

    protected static void showInvalidInputMessage() {
        System.out.println("Ongeldige input! Voer een geldig input in: ");
    }

    protected static Integer scanSelectedInt() {
        selected = scanner.nextInt();
        return selected;
    }

    static void sendBackToMenuOption() {
        System.out.println("0: Terug");
        selected = Menu.scanner.nextInt();
        if(Main.selected == 0) {
            Menu.mainMenu();
        }
    }
}
