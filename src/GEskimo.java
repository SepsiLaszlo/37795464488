import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GEskimo extends GCharacter{
    public GEskimo(Eskimo eskimo) {
        super(eskimo);
        try {
            File imageFile = new File("images/eskimo.png");
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
