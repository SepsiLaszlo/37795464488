package com.company;

import java.util.ArrayList;

/**
 * Felelős azért, hogy a játékosok egymás után határozott sorrendben tudják elvégezni a köreiket
 * és a hóvihar ütemezéséért.
 */
public class Game {
    private static Game instance = new Game();
    private IceField iceField;
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character currCharacter;

    /**
     * Privát konstruktor a Singleton-pattern megvalósításához.
     */
    private Game() {
    }

    /**
     *Visszaadja az egyetlen Game példányt, Singleton-pattern megvalósításához szükséges.
     * @return Game példány.
     */
    public static Game getInstance() {
        return instance;
    }

    /**
     * A játék inicializálását végző metódus.
     * Létrehoz a paraméterben kapott számú eszkimót és sarkkutatót.
     *
     * @param eskimos     Eszkimók száma a játékban.
     * @param researchers Kutatók száma a játékban.
     */
    public void startGame(int eskimos, int researchers) {
        System.out.println(Main.tab + ">Game.startGame(int,int)");
        System.out.println(Main.tab + "<Game.startGame(int,int)");
    }

    /**
     * A szereplő meghalása vagy a játék megnyerése esetén
     * hívandó metódus.
     *
     * @param win Győzelem állapota
     */
    public void endGame(boolean win) {
        System.out.println(Main.tab + ">Game.endGame("+ win +")");
        System.out.println(Main.tab + "<Game.endGame("+ win +")");
    }

    /**
     * Beállítja a soron következő játékost.
     */
    public void nextPlayer() {
        System.out.println(Main.tab + ">Game.nextPlayer()");
        System.out.println(Main.tab + "<Game.nextPlayer()");
    }

    /**
     * Visszaadja a játékosok számát.
     */
    public int getTotalCharactersNumber() {
        System.out.println(Main.tab + ">Game.getTotalCharactersNumber()");
        System.out.println(Main.tab + characters.size() + "<Game.getTotalCharactersNumber()");

        return characters.size();
    }

    /**
     * Elindítja a játékosok köreit váltogató ciklust.
     */
    public void runGame() {
        System.out.println(Main.tab + ">Game.runGame()");
        System.out.println(Main.tab + "<Game.runGame()");
    }

}
