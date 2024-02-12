import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Zak {
    private String jmeno;
    private String prijmeni;
    private String rodneCislo;
    private LocalDate datumNarozeni;
    private boolean chlapec;
    private byte rocnik = -1;

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
    public String pohlavi(){
        return chlapec ? "chlapec" : "dívka";
    }
    public boolean plnoletost(){
        return Period.between(datumNarozeni, LocalDate.now()).get(ChronoUnit.YEARS) >= 18;
    }
    public void zvysRocnik(){
        if(rocnik < 4){
            rocnik++;
        }
    }
    // GEt a SET
    public void setJmeno(String jmeno){
        this.jmeno = jmeno;
    }
    public String getJmeno(){
        return this.jmeno;
    }
    public void setDatumNarozeni(LocalDate datumNarozeni){
        this.datumNarozeni = datumNarozeni;
    }
    public LocalDate getDatumNarozeni(){
        return this.datumNarozeni;
    }
    public void setRodneCislo(String rodneCislo){
        this.rodneCislo = rodneCislo;
    }
    public String getRodneCislo(){
        return this.rodneCislo;
    }
    public void setPrijmeni(String prijmeni){
        this.prijmeni = prijmeni;
    }
    public String getPrijmeni(){
        return this.prijmeni;
    }
    public boolean isChlapec(){
        return this.chlapec;
    }
    public void setChlapec(Boolean chlapec){
        this.chlapec = chlapec;
    }
    public void setRocnik(byte rocnik){
        this.rocnik = rocnik;
    }
    public byte getRocnik(){
        return this.rocnik;
    }

}