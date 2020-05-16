import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * A GCharacter jegesmedvéhez tartozó konkrét leszátmazottja.
 */
public class GPolarBear extends GCharacter {
    /**
     * Konstruktor, ami beállítja a karaktert, a hozzá tartozó képet és az invetorit, ami
     * ez esetben üres, csak a karakter iconját jeleníti meg, hogy jelezze a karakter körét.
     * @param polarBear
     */
    public GPolarBear(PolarBear polarBear) {
        super(polarBear);
        try {
            File imageFile = new File("images/polarbear.png");
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inventory = new Inventory("polarbear.png");
    }
}
