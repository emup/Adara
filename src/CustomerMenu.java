import java.util.ArrayList;
import java.util.Arrays;

public class CustomerMenu extends Menu {
    private static final ArrayList<String> customerMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Klanten:" + ANSI_RESET,
            "1: Voeg klant toe",
            "2: Toon klanten",
            "0: Terug\n"
    ));

    public static void showCustomerMenu(){
        while(checkSelected()) {
            for(String c : customerMenu) {
                System.out.println(c);
            }

            selected = scanner.nextInt();

            switch(selected){
                case 1: Customer.addCustomer();
                case 2: Customer.showCustomers();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    showInvalidInputMessage();
            }
        }
    }
}
