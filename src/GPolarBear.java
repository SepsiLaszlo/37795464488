import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GPolarBear extends GCharacter {
    public GPolarBear(PolarBear polarBear) {
        super(polarBear);
        try {
            File imageFile = new File("images/polarbear.png");
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
