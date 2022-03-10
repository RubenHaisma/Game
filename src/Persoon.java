import java.util.ArrayList;

public class Persoon{
    private String naam;
    private double budget;
    private ArrayList<Game> games = new ArrayList<Game>();

    public Persoon(String nm, double bg) {
        this.naam = nm;
        this.budget = bg;
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        if (getBudget() >= g.huidigeWaarde() && !games.contains(g)) {
            games.add(g);
            budget -= g.huidigeWaarde();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (games.contains(g)) {
            if (!koper.games.contains(g) && koper.getBudget() >= g.huidigeWaarde()) {
                games.remove(g);
                koper.games.add(g);
                koper.budget = koper.budget - g.huidigeWaarde();
                budget = budget + g.huidigeWaarde();
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget));
        for (Game g : games) {
            out.append("\n").append(g);
        }
        out = new StringBuilder(out.toString().replace(".", ","));
        return out.toString();
    }
}