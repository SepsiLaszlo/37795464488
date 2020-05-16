import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A GCharacter eszkimóhoz tartozó konkrét leszátmazottja.
 */
public class GEskimo extends GCharacter{
    /**
     * Konstruktor, ami beállítja a karaktert, hozzá tartozó képet és az inventorit.
     * @param eskimo
     */
    public GEskimo(Eskimo eskimo) {
        super(eskimo);
        try {
            File imageFile = new File("images/eskimo.png");
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inventory = new Inventory("eskimo.png");
        inventory.addItem(new GPickable("signalrocket.png", true));
    }
}
