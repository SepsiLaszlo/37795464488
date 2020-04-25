/**
 *  Irány a játékos mozgásához.
 */
public class Direction {
    private int name;

    /**
     * Az irány osztály konstruktora.
     * @param name az irány neve/értéke
     */
    public Direction(int name){
        this.name = name;
    }

    /**
     * Megnézi, hogy az irányok megegyeznek-e.
     * @param d irány
     * @return irényok megegyeznek-e
     */
    public boolean equals(Object d){
        return ((Direction)d).getName() == this.name;
    }

    /**
     * Az irány nevének lekérdezése.
     * @return
     */
    public int getName() {
        return name;
    }

    /**
     * Az objektum hash kódjának lekérdezése.
     * @return hash kód
     */
    public int hashCode() {
        return name;
    }

    /**
     * Visszaadja a saját adattagját string formátumban.
     * @return adattag string formátumban
     */
    @Override
    public String toString() {
        return "d" + this.name;
    }
}
