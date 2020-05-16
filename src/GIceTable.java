import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A kirajzolható jégtábla objektumok ősosztálya.
 */
public class GIceTable implements IDrawable {
    private IceTable iceTable;
    protected BufferedImage iceTableImg;
    private GPickable item;
    private BufferedImage snowImg;
    private BufferedImage igluImg;
    private BufferedImage tentImg;

    /**
     * Konstruktor, ami beállítja a jégtáblát, a benne lévő tárgy nézetét, és a jégtábla különböző
     * állapotaihoz tartozó képeket.
     * @param iceTable
     * @param item
     */
    public GIceTable(IceTable iceTable, GPickable item) {
        this.iceTable = iceTable;
        this.item = item;
        try {
            File imageFile = new File("images/snow.png");
            snowImg = ImageIO.read(imageFile);
            imageFile = new File("images/iglu.png");
            igluImg = ImageIO.read(imageFile);
            imageFile = new File("images/tent.png");
            tentImg = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Kirajzolja magát a paraméterben megadott helyre, a jégtábla állapotának megfelelően.
     * @param g Az objektum, amire kirajzolja magát.
     * @param x x szerinti pozíció.
     * @param y y szerinti pozíció.
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(iceTableImg, x, y, null);
        if(iceTable.getIgluState())
            g.drawImage(igluImg, x + 64, y, null);
        if(iceTable.getTentState())
            g.drawImage(tentImg, x + 64, y + 64, null);
        if(item != null)
            item.draw(g, x, y + 64);
        if(iceTable.anySnow())
            g.drawImage(snowImg, x, y, null);
    }

    /**
     * A nézethez tartozó jégtábla lekérdezése.
     * @return A nézethez tartozó jégtábla.
     */
    public IceTable getIceTable() {
        return iceTable;
    }

    /**
     * Ellenőrzi, hogy a jégtáblából kivették-e a tárgyat. Ha igen és Usable típusú,
     * akkor visszatér a tárgyhoz tartozó nézettel.
     * @return A tárgyhoz tartozó nézet.
     */
    public GPickable checkItemPickup() {
        if(item != null && !iceTable.containsItem()) {
            GPickable item = this.item;
            this.item = null;
            if (item.isUseableItem())
                return item;
        }
        return null;
    }
}
