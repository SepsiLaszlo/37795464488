import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory implements IDrawable {
    private ArrayList<GPickable> items = new ArrayList<GPickable>();
    private BufferedImage icon;

    public Inventory(String iconName) {
        try {
            File imageFile = new File("images/" + iconName);
            this.icon = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Kirajzolja magát a paraméterben átadott helyre.
     * @param g Az objektum, amire kirajzolja magát.
     * @param x x szerinti pozíció.
     * @param y y szerinti pozíció.
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 64, 64);
        g.drawImage(icon, x, y, null);

        g.setColor(Color.BLACK);
        int posX = x + 64;
        for (GPickable img: items) {
            g.drawRect(posX, y, 64, 64);
            img.draw(g, posX, y);
            posX += 64;
        }
    }

    public void addItem(GPickable item) {
        items.add(item);
    }
}
