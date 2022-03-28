public class Customer {
    private static int hoogstenr = 0;
    private int nr = hoogstenr++;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Klantnr:" + nr + ", naam: " + name;
    }
}
