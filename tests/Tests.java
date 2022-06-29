import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    void testKist() {
        // arrange
        Kist kists = new Kist(100);
        int expected = 80;

        // act
        kists.addAmount(43);
        kists.removeAmount(63);
        int result = kists.getAmount();

        // assert
        assertEquals(expected, result);
    }

    @Test
    void testGetCustomerFromId() {
        // arrange
        ArrayList<Customer> c = new ArrayList<>();
        c.add(new Customer("Oracle Corporation"));
        c.add(new Customer("De Haagse Hogeschool"));
        String expected = "Ordernr: 0, naam: Rozen voor valentijnsdag, klant: Klantnr:1" +
                ", naam: De Haagse Hogeschool, kisten nodig: 20, kisten gebruikt: 20";

        // act
        Order order = new Order("Rozen voor valentijnsdag", Main.getCustomerFromId(1, c), 20, 20);
        String result = String.valueOf(order);

        // result
        assertEquals(expected, result);
    }

    @Test
    void testGetKistNeeded() {
        // arrange
        Customer c = new Customer("Rademaker");
        Order o = new Order("Maandelijkse levering April", c, 40, 80);
        int expected = 40;

        // act
        int result = o.getKistNeeded();

        // result
        assertEquals(expected, result);
    }
}
