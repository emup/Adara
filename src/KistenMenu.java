import java.util.ArrayList;
import java.util.Arrays;

public class KistenMenu extends Menu{
    private static final ArrayList<String> kistenMenu = new ArrayList<>(Arrays.asList(
            ANSI_CYAN + "Kisten" + ANSI_RESET,
            "1: Toon hoeveelheid kisten",
            "2: Toevoegen kist",
            "3: Verwijder kist",
            "0: Terug\n"
    ));

    public static void showKistenMenu(){
        while(checkSelected()) {
            for(String k : kistenMenu) {
                System.out.println(k);
            }

            selected = scanner.nextInt();

            switch(selected){
                case 1: Kist.showKisten();
                case 2: Kist.addKist();
                case 3: Kist.removeKist();
                case 0:
                    selected = null;
                    mainMenu();
                default:
                    System.out.println("Ongeldige input! Voer een geldig input in: ");
            }
        }
    }
}
