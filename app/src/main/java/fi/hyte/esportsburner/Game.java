package fi.hyte.esportsburner;

public class Game {
    private String name;
    private int kalorit;
    private int imageid;

    public Game(String name, int kalorit, Integer imageid){
        this.name = name;
        this.kalorit = kalorit;
        this.imageid = imageid;
    }

    public Game(String name, int kalorit){
        this.name = name;
        this.kalorit = kalorit;
        this.imageid = R.drawable.eikuvaa;
    }

    public int getImageid(){
        return this.imageid;
    }
    public int getKalorit(){
        return this.kalorit;
    }

    @Override
    public String toString() {
        return name;
    }
}
