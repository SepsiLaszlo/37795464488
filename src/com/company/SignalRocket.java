package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A jelzőrakéta tárolja az eddig megtalált részeit. Ha a játékosok az összes részét megtalálták,
 *és egy táblán állnak, akkor elsütésével megnyerik a játékot, erről az osztály értesíti a Game-et.
 * Singleton osztály.
 */
public class SignalRocket implements Usable {
    private static SignalRocket instance = new SignalRocket();
    private Game game = Game.getInstance();
    private ArrayList<SignalRocketPart> parts;

    /**
     * Privát konstruktor a Singleton-pattern megvalósításához.
     */
    private SignalRocket() {
    }

    /**
     *Visszaadja az egyetlen SignalRocket példányt, Singleton-pattern megvalósításához szükséges.
     * @return SignalRocket példány.
     */
    public static SignalRocket getInstance() {
        return instance;
    }

    /**
     * Először megvizsgálja, hogy a parts listának 3 eleme van-e,
     *  ami ha teljesül lekéri a paraméterül kapott karakter mezőjét.
     * Ezután a mezőn meghívja a getCharactersNumber()-t,
     *  a game tagváltozóján pedig a getTotalCharactersNumber()-t.
     * Amennyiben ezeknek a száma egyezik meghívja a game-en az endGame(true)-t,
     *  ezzel jelezve, hogy megnyerték a játékot.
     * @param c a karakter, aki meghívja a függvényt
     * @param d a tárgy használatánk iránya
     */
    @Override
    public void use(Character c, Direction d) {
        IceTable i = c.getIceTable();
        int CharacterNumber=i.getCharactersNumber();
        int TotalCharactersNumber=game.getTotalCharactersNumber();

        if (parts.size()==3 && CharacterNumber==TotalCharactersNumber){
            game.endGame(true);
        }
    }

    /**
     * Egy karakter hívja meg, ha felvesz alkatrészt (SignalRocketPart),
     *  amit a SignalRocket eltárol a parts listájában.
     * @param s a felvett alkatrész
     */
    public void build(SignalRocketPart s) {
        parts.add(s);
    }
<<<<<<< Updated upstream
=======

    public  String toString(){
        return  "SignalRocket foundParts: " + parts.size();
    }
>>>>>>> Stashed changes
}
