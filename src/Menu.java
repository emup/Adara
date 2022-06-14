import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu extends Main {
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

            selected = scanner.nextInt();

            switch (selected) {
                case 1:
                    KistenMenu.showKistenMenu();
                case 2:
                    OrderMenu.showOrderMenu();
                case 3:
                    CustomerMenu.showCustomerMenu();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
            }
        }
    }












}
