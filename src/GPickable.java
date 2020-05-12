import java.awt.*;

public class GPickable implements IDrawable{
    private Image img;

    @Override
    public void draw(Graphics2D g, int x, int y) {
        g.drawImage(img, x, y, null);
    }
}
