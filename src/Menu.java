import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu extends Main {
    private final Scanner scanner = new Scanner(System.in);

    private final ArrayList<String> mainMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Hoofdmenu" + ANSI_RESET,
            "1: Kisten",
            "2: Bestellingen",
            "3: Klanten",
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
            "1: Voeg bestelling toe",
            "2: Toon bestellingen",
            "3: Toon volledig vervulde bestellingen",
            "0: Terug\n"
    ));

    private final ArrayList<String> customerMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Klanten:" + ANSI_RESET,
            "1: Voeg klant toe",
            "2: Toon klanten",
            "0: Terug\n"
    ));


    public Menu(){
        mainMenu();
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
                case 3:
                    customerMenu();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
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
                case 1: addOrder();
                case 2: showOrders();
                case 3: showOrdersFulfilled();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
            }
        }
    }

    public void customerMenu(){
        while(checkSelected()) {
            for(String c : customerMenu) {
                System.out.println(c);
            }

            selected = scanner.nextInt();

            switch(selected){
                case 1: addCustomer();
                case 2: showCustomers();
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

    public void addOrder() {
        System.out.println(ANSI_CYAN + "Order toevoegen" + ANSI_RESET);
        System.out.println("Ordernaam: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Klantnr: ");
        int customer = scanner.nextInt();
        System.out.println("Hoeveel kisten nodig?: ");
        int kn = scanner.nextInt();
        System.out.println("Hoeveel kisten al gevuld?: ");
        int ku = scanner.nextInt();
        orders.add(new Order(name, getCustomerFromId(customer, customers), kn, ku));
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Order toegevoegd!" + ANSI_RESET + "\n");
        orderMenu();
    }

    public void showOrders() {
        if(checkSelected()) {
            for (Order o : orders) {
                System.out.println("- " + o);
            }
            System.out.println("0: Terug");
            selected = scanner.nextInt();
            if(selected == 0) {
                mainMenu();
            }
        }
    }

    public void showOrdersFulfilled() {
        while(checkSelected()) {
            for (Order o : orders) {
                if(o.getKistUsed() == o.getKistNeeded()) {
                    System.out.println("- " + o);
                }
            }
            System.out.println("0: Terug");
            selected = scanner.nextInt();
            if(selected == 0) {
                mainMenu();
            }
        }
    }

    public void addCustomer() {
        System.out.println(ANSI_CYAN + "Klant toevoegen" + ANSI_RESET);
        System.out.println("Naam: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        customers.add(new Customer(name));
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Klant toegevoegd!" + ANSI_RESET + "\n");
        customerMenu();
    }

    public void showCustomers() {
        if(checkSelected()) {
            for (Customer c : customers) {
                System.out.println("- " + c);
            }
            System.out.println("0: Terug");
            selected = scanner.nextInt();
            if(selected == 0) {
                customerMenu();
            }
        }
    }
}
