package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(Main.tab + ">SignalRocket.use(Character, Direction)");
        Main.tab += "\t";

        IceTable i = c.getIceTable();
        i.getCharactersNumber();
        game.getTotalCharactersNumber();

        System.out.println("Mindenki egy jégtáblán van-e és megtalálták az összes alkatrészt?\n" +
                "Válasz: Y (Igen), N (Nem).");
        Scanner in = new Scanner(System.in);
        char answer = in.next().charAt(0);
        while (answer != 'N' && answer != 'Y') {
            System.out.println("Hibás válasz!\n" +
                    "Mindenki egy jégtáblán van-e és megtalálták az összes alkatrészt?\n" +
                    "Válasz: Y (Igen), N (Nem).");
            answer = in.next().charAt(0);
        }
        if(answer == 'Y') {
            game.endGame(true);
        }

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + "<SignalRocket.use(Character, Direction)");
    }

    /**
     * Egy karakter hívja meg, ha felvesz alkatrészt (SignalRocketPart),
     *  amit a SignalRocket eltárol a parts listájában.
     * @param s a felvett alkatrész
     */
    public void build(SignalRocketPart s) {
        System.out.println(Main.tab + ">SignalRocket.build(SignalRocketPart)");
        System.out.println(Main.tab + "<SignalRocket.build(SignalRocketPart)");
    }
}
