import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A kirajzolható karakterobjektumok ősosztálya.
 */
public  class GCharacter implements IDrawable{
    protected BufferedImage img;
    private Character character;
    protected Inventory inventory;

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

    public void drawInventory(Graphics g, int x, int y, int id) {
        inventory.draw(g, x, y);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 16));
        g.drawString(String.valueOf(id), x + 5, y + 15);
        g.setColor(Color.BLACK);
        g.drawString(String.format("Workunit: %d", character.getWorkUnit()), x + 10, y + 78);
        g.drawString(String.format("Body temperature: %d", character.getBodyTemperature()), x + 128, y + 78);
        g.drawString(String.format("Diver: %s", character.isDiver()), x + 320, y + 78);
    }

    /**
     * Annak a jégmezőnek a lekérdezése, amin a nézet által tartalmazott karakter áll.
     * @return Jégtábla, amin a karakter áll.
     */
    public IceTable getIceTable(){
        return character.getIceTable();
    }

    public Character getCharacter(){
        return character;
    }

    public void addItem(GPickable item) {
        if(item != null)
            inventory.addItem(item);
    }
}
