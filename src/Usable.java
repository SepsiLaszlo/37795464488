/**
 * A használható tárgyakat reprezentáló interface.
 */
public interface Usable {
    /**
     * Az interface-t megvalósító osztályoknak egy közös tulajdonságuk van,
     *  hogy lehet őket használni. Minden osztály különbözően valósítja meg.
     * @param c a karakter, aki meghívja a függvényt
     * @param d a tárgy használatánk iránya
     */
    public void use(Character c, Direction d);
}
