package h4h.springboot.postgresexample;

public class CustomExc extends Exception {

    public CustomExc(String msg) {
        super(msg);
    }
}