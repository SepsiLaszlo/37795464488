package com.company;

import java.util.ArrayList;

/**
 * Felelős azért, hogy a játékosok egymás után határozott sorrendben tudják elvégezni a köreiket
 * és a hóvihar ütemezéséért.
 */
public class Game {
    private static Game instance = new Game();
    private IceField iceField = new IceField();
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character currCharacter;
    private GameState gameState = GameState.RUNNING;

    /**
     * Privát konstruktor a Singleton-pattern megvalósításához.
     */
    private Game() { }

    /**
     *Visszaadja az egyetlen Game példányt, Singleton-pattern megvalósításához szükséges.
     * @return Game példány.
     */
    public static Game getInstance() {
        return instance;
    }

    /**
     * Egy karakter hozzáadása a characters listához.
     * @param c hozzáadandó karakter
     */
    public void addCharacter(Character c) {
        characters.add(c);
    }

    /**
     * A szereplő meghalása vagy a játék megnyerése esetén
     * hívandó metódus.
     * @param win Győzelem állapota
     */
    public void endGame(boolean win) {
        if(win) {
            gameState = GameState.WIN;
        } else {
            gameState = GameState.LOSE;
        }
    }

    /**
     * Beállítja a soron következő játékost.
     */
    public void nextPlayer() {
        int index = characters.indexOf(currCharacter) + 1;
        currCharacter = characters.get(index % characters.size());
    }

    /**
     * Visszaadja a játékosok számát.
     */
    public int getTotalCharactersNumber() {
        return characters.size();
    }

    /**
     * Elindítja a játékosok köreit váltogató ciklust.
     */
    public void runGame() {
        if(characters.size() < 3) {
            return;
        }
        gameState = GameState.RUNNING;
        currCharacter = characters.get(0);

        while (gameState == GameState.RUNNING) {
            Character c = currCharacter;
            while (c == currCharacter) {
                //Character move, dig, use Item
            }
            iceField.snowStorm(false);
        }
    }

    /**
     * Visszaadja a saját adattagjait string formátumban. Az alábbi
     * formában: primitív esetben tagváltozó név: érték, egyébként tagváltozó név: típus (pl.
     * Game-ben az IceField). A tárolt karakterek tömbje esetén kiírjuk a tömb nevét, és alá
     * a tömbben lévő karaktereket a fentebb említett formában. Emellett kiírja a játék
     * állapotát: (RUNNING, LOSE, WIN). Ez a metódus a tesztelést segíti.
     * @return adattagok string formátumban
     */
    public String printStat() {
        String output = String.format("Game\n" +
                "iceField: IceField\n" +
                "characters:\n" +
                "gameState: %s\n", gameState);
        return output;
    }
}
