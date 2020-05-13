import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GHole extends GIceTable{

    public GHole(Hole hole) {
        super(hole, null);
        try {
            File imageFile = new File("images/hole.png");
            iceTableImg = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
