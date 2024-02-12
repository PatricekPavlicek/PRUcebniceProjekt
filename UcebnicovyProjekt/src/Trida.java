import java.util.ArrayList;

public class Trida {
    private ArrayList<Zak> zaci;
    private byte rocnik;
    private String tridni;

    public Trida(byte rocnik, String tridni){
        this.rocnik = rocnik;
        this.tridni = tridni;
        zaci = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Trida{" +
                "zaci=" + zaci +
                ", rocnik=" + rocnik +
                ", tridni='" + tridni + '\'' +
                '}';
    }
    public String vratInfo(){
        return String.format("%d. třída (Třídní: %s)%n", rocnik, tridni) + vratSeznamZaku();
    }

    public String vratSeznamZaku(){
        StringBuilder sb = new StringBuilder();

        sb.append("Seznam Žáků:\n------------------------------\n");
        zaci.forEach(zak -> sb.append(zak.vratInfo()).append("\n"));
        sb.append("------------------------------");

        return sb.toString();
    }

    public String vratOcislovnySeznamZaku(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < zaci.size(); i++){
            Zak zak = zaci.get(i);
            sb.append(i + 1);
            sb.append(" ");
            sb.append(zak.getJmeno()).append(" ").append(zak.getPrijmeni());
            sb.append("\n");
        }

        return sb.toString();
    }
    public boolean jeZakVeTride(Zak hledanyZak){
        return zaci.stream().anyMatch(zak -> zak.equals(hledanyZak));
    }
    public void pridejNovehoZaka(Zak zak){
        if(!jeZakVeTride(zak)){
            zaci.add(zak);
        }
        else{
            System.out.println("Žák už ve třídeě existuje!");
        }
    }
    public void odeberZaka(Zak odebiranyZak){
        String osloveni = odebiranyZak.isChlapec() ? "Žák" : "Žákyně";
        boolean odebran = zaci.removeIf(zak -> zak.equals(odebiranyZak));

        if(odebran){
            System.out.printf("%s %s %s byl odstraněn z %d. třídy%n", osloveni, odebiranyZak.getJmeno(), odebiranyZak.getPrijmeni(), odebiranyZak.getRocnik());
        }
        else{
            System.out.println(odebiranyZak + " nebyl v seznamu nalezen");
        }
    }

    public void zvysRocnik(){
        // Zvýšení ročníku třídy
        if(rocnik < 4){
            rocnik++;
        }

        // Zvýšení ročníku každého žáka
        zaci.forEach(Zak::zvysRocnik);
    }
    public void setRocnik(byte rocnik){
        this.rocnik = rocnik;
    }

    public String vratZaka(String rodneCislo){
        for(int i = 0; i < zaci.size(); i++){
            Zak zak = zaci.get(i);
            if(zak.getRodneCislo().equals(rodneCislo)){
                return zak.vratInfo();
            }
        }
        return "Žák se zadaným rodným číslem neexistuje";
    }
    public String vratZaka(int index){
        if(index < zaci.size() && index >= 0){
            return zaci.get(index).vratInfo();
        }
        else{
            return "Zadaný index neexistuje";
        }
    }
}
