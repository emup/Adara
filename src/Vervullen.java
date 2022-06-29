abstract class Vervullen { // Template Method Pattern
    abstract void vragen();
    abstract void updaten(Object... args);
    abstract void confirmatie();

    public final void vervulproces(Object... args) { // varargs are amazing
        vragen();
        updaten(args);
        confirmatie();
    }
}
