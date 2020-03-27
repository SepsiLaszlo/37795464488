package com.company;

import java.util.ArrayList;

public class SignalRocket implements Usable {
    private Game game;
    private ArrayList<SignalRocketPart> parts;

    /**
     * Eltárolja a game nevű tagváltozójában a paraméterül kapott g-t;
     * @param g a játék osztálya
     */
    public SignalRocket(Game g) {
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
    }

    /**
     * Egy karakter hívja meg, ha felvesz alkatrészt (SignalRocketPart),
     *  amit a SignalRocket eltárol a parts listájában.
     * @param s a felvett alkatrész
     */
    public void build(SignalRocketPart s) {
    }
}
