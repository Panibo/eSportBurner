package fi.hyte.esportsburner;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private static  final Global ourInstance = new Global();

    private List<Game> lista;
    public static Global getInstance(){
        return  ourInstance;
    }

    private Global(){
        lista = new ArrayList<>();

        lista.add(new Game("CSS", 150));
        lista.add(new Game("Minecraft", 100));
        lista.add(new Game("Pasianssi", 75));
        lista.add(new Game("COD", 185));
        lista.add(new Game("RDR2", 110));

    }

    public  List<Game> getGames(){
        return lista;
    }
}
