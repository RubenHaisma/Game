import java.time.LocalDate;

public class Game{
    private String naam;
    private int releaseDate;
    private double nieuwprijs;

    public Game(String nm, int rD, double nwpr) {
        this.naam = nm;
        this.releaseDate = rD;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int release = (LocalDate.now().getYear() - releaseDate);
        double prijs = nieuwprijs;
        for (int i = 0; i < release; i++) {
            prijs *= 0.7;
        }
        return prijs;
    }

    public String toString() {
        String out = "";
        out += String.format("%s, uitgegeven in %s; nieuwprijs: €%.2f nu voor: €%.2f", naam, releaseDate, nieuwprijs, huidigeWaarde());
        out = out.replace(".", ",");
        return out;
    }

}