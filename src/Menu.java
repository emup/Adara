import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu extends Main {
    private Kist kisten = new Kist(100);
    private final Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    private final ArrayList<String> mainMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Hoofdmenu" + ANSI_RESET,
            "1: Kisten",
            "2: Bestellingen",
            "0: Sluit programma\n"
    ));

    private final ArrayList<String> kistenMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Kisten" + ANSI_RESET,
            "1: Toon hoeveelheid kisten",
            "2: Toevoegen kist",
            "3: Verwijder kist",
            "0: Terug\n"
    ));

    private final ArrayList<String> orderMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Bestellingen:" + ANSI_RESET,
            "1: Toon bestellingen",
            "2: Voeg bestelling toe",
            "0: Terug\n"
    ));


    public Menu(){
        mainMenu();
    }

    private Boolean checkSelected() {
        return selected == null || selected != 0;
    }

    public void mainMenu(){
        while(checkSelected()) {
            for(String m : mainMenu) {
                System.out.println(m);
            }

            selected = scanner.nextInt();

            switch (selected) {
                case 1:
                    kistenMenu();
                case 2:
                    orderMenu();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Voer een geldige keuze in: ");
            }
        }
    }

    public void kistenMenu(){
        while(checkSelected()) {
            for(String k : kistenMenu) {
                System.out.println(k);
            }

            selected = scanner.nextInt();

            switch(selected){
                case 1: showKisten();
                case 2: addKist();
                case 3: removeKist();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
            }
        }
    }

    public void orderMenu(){
        while(checkSelected()) {
            for(String o : orderMenu) {
                System.out.println(o);
            }

            selected = scanner.nextInt();

            switch(selected){
                case 1: showOrders();
                case 2: addOrder();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
            }
        }
    }

    public void showKisten() {
        int amount = kisten.getAmount();
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Er zijn " + amount + " kisten" + ANSI_RESET + "\n");
        kistenMenu();
    }

    public void addKist() {
        System.out.println(ANSI_CYAN + "Hoeveel kisten wilt u toevoegen?" + ANSI_RESET);
        int amount = scanner.nextInt();
        kisten.addAmount(amount);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + amount + " kisten toegevoegd!" + ANSI_RESET + "\n");
        kistenMenu();
    }

    public void removeKist() {
        System.out.println(ANSI_CYAN + "Hoeveel kisten wilt u verwijderen?" + ANSI_RESET);
        int amount = scanner.nextInt();
        kisten.removeAmount(amount);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + amount + " kisten verwijderd!" + ANSI_RESET + "\n");
        kistenMenu();
    }

    public void addOrder() {}
}
