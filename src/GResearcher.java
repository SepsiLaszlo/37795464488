import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A GCharacter sarkkutatóhoz tartozó konkrét leszátmazottja.
 */
public class GResearcher extends GCharacter{
    /**
     * Konstruktor, ami beállítja a karaktert és a hozzá tartozó képet.
     * @param researcher
     */
    public GResearcher(Researcher researcher) {
        super(researcher);
        try {
            File imageFile = new File("images/researcher.png");
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
