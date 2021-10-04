package fi.hyte.esportsburner;

public class Game {
    private String name;
    private int kalorit;

    public Game(String name, int kalorit){
        this.name = name;
        this.kalorit = kalorit;
    }

    @Override
    public String toString() {
        return name;
    }
}
