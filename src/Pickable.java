/**
 * A felvehető tárgyakat reprezentáló interface.
 */
public interface Pickable {
    /**
     * Ezt hívja meg a karakter, amikor felveszi. Minden leszármazott máshogy valósítja meg.
     * @param c - A karakter, aki felveszi a tárgyat.
     */
    void pickUp(Character c);
}
