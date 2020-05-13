import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GResearcher extends GCharacter{
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
