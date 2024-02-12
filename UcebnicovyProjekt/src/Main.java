import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        String jmeno = "Pepa";
        String prijmeni = "Pavel";
        String rodneCislo = "050505/1234";
        LocalDate datumNarozeni = LocalDate.of(2000, 9, 5);
        boolean chlapec = true;
        byte rocnik = 2;

        Zak zak = new Zak(jmeno, prijmeni, rodneCislo, datumNarozeni, chlapec, rocnik);
        System.out.println(zak.vratInfo());
        System.out.println(zak.vratInfo2());
        System.out.println(zak);


        Trida trida1 = new Trida((byte) 1, "Pepa Pavel");
    }
}