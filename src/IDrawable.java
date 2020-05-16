import java.awt.*;

/**
 * Interfész a kirajzolható objektumok számára.
 */
public interface IDrawable {
    /**
     * Minden kirajzolható obkektum saját maga tudja majd, hogy hogyan kell kirajzolni magát,
     * amire ezt a függvényt fogják használni.
     * @param g Az objektum, amire kirajzolja magát.
     * @param x x szerinti pozíció.
     * @param y y szerinti pozíció.
     */
    void draw(Graphics g, int x, int y);
}
