import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GIceTable implements IDrawable {
    private IceTable iceTable;
    protected BufferedImage iceTableImg;
    private GPickable item;
    private BufferedImage snowImg;
    private BufferedImage igluImg;
    private BufferedImage tentImg;

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

    @Override
    public void draw(Graphics g, int x, int y) {
        if(item != null && !iceTable.containsItem())
            item = null;

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

    public IceTable getIceTable() {
        return iceTable;
    }
}
