import java.util.ArrayList;
import java.util.Arrays;

public class OrderMenu extends Menu {
    private static final ArrayList<String> orderMenu = new ArrayList<>(Arrays.asList(
            Main.ANSI_CYAN + "Bestellingen:" + Main.ANSI_RESET,
            "1: Voeg bestelling toe",
            "2: Voeg kisten toe aan bestelling",
            "3: Toon bestellingen",
            "4: Toon volledig vervulde bestellingen",
            "0: Terug\n"
    ));

    public static void showOrderMenu(){
        while(checkSelected()) {
            for(String o : orderMenu) {
                System.out.println(o);
            }

            switch(scanSelectedInt()){
                case 1: Order.addOrder();
                case 2: Order.fulfillOrder();
                case 3: Order.showOrders();
                case 4: Order.showOrdersFulfilled();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    showInvalidInputMessage();
            }
        }
    }
}
