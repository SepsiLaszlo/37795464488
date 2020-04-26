/**
 * A buvárruhát reprezentáló osztály. Ha a játékoson van búvárruha, akkor vízbe esés esetén ki tud mászni a vízből.
 */
public class DivingSuit implements Pickable {
    /**
     * A paraméterben kapott karakteren meghívja makeDiver() függvényt, ezzel a játékos felveszi a búvárruhát.
     * @param c - A karakter, aki felveszi a tárgyat.
     */
    public void pickUp(Character c) {
        c.makeDiver();
    }

    /**
     * Visszaadja az osztály típusát string formátumban.
     * @return az osztály típusa
     */
    public String toString() {
        return "Diving Suit";
    }
}
