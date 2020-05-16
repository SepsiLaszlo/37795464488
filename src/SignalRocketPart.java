/**
 * A jelzőrakéta összeszereléséhez kellő alkatrész. A játék megnyeréséhez szükséges a megszerzésük. Összesen 3 ilyen van.
 */
public class SignalRocketPart implements Pickable {
    /**
     * A paraméterben kapott karakteren meghívja a BuildSignalRocket(Pickable: i) függvényt, ezzel hozzáadva magát a SignalRocket-hez.
     * @param c - A karakter, aki felveszi a tárgyat.
     */
    public void pickUp(Character c) {
        c.buildSignalRocket(this);
    }
}
