import java.awt.*;

public abstract class GIceTable implements IDrawable {
    protected Image img;
    private GPickable item;

    public GIceTable(GPickable gp) {
        item=gp;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        g.drawImage(img, x, y, null);
        item.draw(g, x, y);
    }

    public abstract IceTable getIceTable();
}
