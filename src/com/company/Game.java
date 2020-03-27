package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private IceField iceField;
    private ArrayList<Character>characters;
    private Character currCharacter;
    /** A játék inicializálását végző metódus.
Létrehoz a paraméterben kapott számú eszkimót és sarkkutatót.
    * @param eskimos Eszkimók száma a játékban.
    * @param researchers Kutatók száma a játékban.
    */
    public void startGame(int eskimos,int researchers){}

    /**A szereplő meghalása vagy a játék megnyerése esetén
hívandó metódus.
     * @param win Győzelem állapota
     */
    public void endGame(boolean win){}

    /**Beállítja a soron következő játékost.
     */
    public void nextPlayer(){}

    /**Visszaadja a játékosok számát.
     */
    public int getTotalCharactersNumber(){return 0;}

    /**Elindítja a játékosok köreit váltogató ciklust.
     */
    public void runGame(){}

}
