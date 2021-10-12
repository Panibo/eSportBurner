package fi.hyte.esportsburner;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Luokka joka sisältää pelin tarvitsemat tiedot
 * @author Miro
 */

public class Game {
    private final String name;
    private final int kalorit;
    private final int imageid;


    /**
     * Konstruktori kun pelin kuva on tiedoissa
     * @param name pelin nimi
     * @param kalorit pelin tunnissa polttamat kalorit
     * @param imageid pelin kuvan id
     */
    public Game(String name, int kalorit, Integer imageid){
        this.name = name;
        this.kalorit = kalorit;
        this.imageid = imageid;
    }

    /**
     * Konstruktori kun pelin kuvaa ei ole tiedoissa
     * @param name pelin nimi
     * @param kalorit pelin tunnissa polttamat kalorit
     */
    public Game(String name, int kalorit){
        this.name = name;
        this.kalorit = kalorit;
        this.imageid = R.drawable.eikuvaa;
    }

    /**
     * @return palauttaa pelin kuvan id:n
     */
    public int getImageid(){
        return this.imageid;
    }

    /**
     * @return palauttaa pelin tunnissa polttamat kalorit
     */
    public int getKalorit(){
        return this.kalorit;
    }

    /**
     * @return palauttaa pelin nimen
     */
    @Override
    public String toString() {
        return name;
    }
}
