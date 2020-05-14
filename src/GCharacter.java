import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A kirajzolható karakterobjektumok ősosztálya.
 */
public  class GCharacter implements IDrawable{
    protected BufferedImage img;
    private Character character;

    /**
     * Konstruktor, ami beállítja a karaktert.
     * @param character
     */
    public GCharacter(Character character) {
        this.character = character;
    }

    /**
     * Kirajzolja magát a paraméterben átadott helyre.
     * @param g Az objektum, amire kirajzolja magát.
     * @param x x szerinti pozíció.
     * @param y y szerinti pozíció.
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(img, x, y, null);
    }

    /**
     * Annak a jégmezőnek a lekérdezése, amin a nézet által tartalmazott karakter áll.
     * @return Jégtábla, amin a karakter áll.
     */
    public  IceTable getIceTable(){
        return character.getIceTable();
    }
}
