import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Zak {
    public String jmeno;
    public String prijmeni;
    public String rodneCislo;
    public LocalDate datumNarozeni;
    public boolean chlapec;
    public byte rocnik = -1;

    //Se vším
    public Zak(String jmeno, String prijmeni, String rodneCislo, LocalDate datumNarozeni, boolean chlapec, byte rocnik){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rodneCislo = rodneCislo;
        this.datumNarozeni = datumNarozeni;
        this.chlapec = chlapec;
        this.rocnik = rocnik;
    }

    //Všechno krom ročníku
    public Zak(String jmeno, String prijmeni, String rodneCislo, LocalDate datumNarozeni, boolean chlapec){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rodneCislo = rodneCislo;
        this.datumNarozeni = datumNarozeni;
        this.chlapec = chlapec;
    }

    //Empty
    public Zak(){

    }

    @Override
    public String toString(){
        return String.format("Zak{jmeno='%s', prijmeni='%s', rodneCislo='%s', datumNarozeni='%s', chlapec=%s, rocnik=%s", jmeno, prijmeni, rodneCislo, datumNarozeni, chlapec, rocnik);
    }
    public String vratInfo(){
        String datum = datumNarozeni.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        return String.format("%s %s (%s), %s. ročník", jmeno, prijmeni, datum, rocnik);
    }
    public String vratInfo2(){
        String typRocniku = rocnik == 4 ? "maturitní" : "nematuritní";
        String pohlavi = chlapec ? "chlapec" : "dívka";
        return String.format("%s %s - %s, %s ročník", jmeno, prijmeni, pohlavi, typRocniku);
    }
}