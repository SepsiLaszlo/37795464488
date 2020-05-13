import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GNormalTable extends GIceTable{
    public GNormalTable(IceTable iceTable, GPickable item) {
        super(iceTable, item);
        try {
            File imageFile = new File("images/icetable.png");
            iceTableImg = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
