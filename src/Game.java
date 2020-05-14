import java.util.ArrayList;
import java.util.Random;

/**
 * A játék állapota.
 */
enum GameState{
    RUNNING,WIN,LOSE
}

/**
 * Felelős azért, hogy a játékosok egymás után határozott sorrendben tudják elvégezni a köreiket
 * és a hóvihar ütemezéséért.
 */

public class Game {
    private static Game instance = new Game();
    private IceField iceField;
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character currCharacter;
    private GameState gameState = GameState.RUNNING;
    private View view;

    /**
     * Privát konstruktor a Singleton-pattern megvalósításához.
     */
    private Game() { }

    /**
     * Visszaadja az egyetlen Game példányt, Singleton-pattern megvalósításához szükséges.
     *
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
       gameState = win?GameState.WIN:GameState.LOSE;
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
            iceField.snowStorm();
        }
    }

    /**
     * A játék alaphelyzetbe állítása: játékosok törlése, jégmező és a játék állapotának
     * visszaállítása.
     */
    public void reset() {
        characters.clear();
        currCharacter = null;
        gameState = GameState.RUNNING;
        SignalRocket.getInstance().reset();
    }

    /**
     * A jelenlegi, azaz az éppen soron lévő játékos lekérdezése.
     * @return A soron lévő játékos.
     */
    Character getCurrCharacter(){
        return  currCharacter;
    }

    /**
     * A játék kiinduási helyzetbe állítása a paraméterként megadott számú játékossal.
     * @param eskimo Az eszkimók száma.
     * @param researcher A sarkkutatók száma.
     */
    public void setupGame(int eskimo, int researcher) {
        reset();
        view = new View();
        iceField = view.init(6, 6, eskimo, researcher);
    }
}
