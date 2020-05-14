import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A felvehető tárgyak kirajzolásához tartozó osztály.
 */
public class GPickable implements IDrawable{
    private Image img;

    /**
     * Konstruktor, ami a paraméternek megfelelően beállítja az osztályhoz tartozó képet.
     * @param imageName
     */
    public GPickable(String imageName) {
        try {
            File imageFile = new File("images/" + imageName);
            img = ImageIO.read(imageFile);
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
        g.drawImage(img, x, y, null);
    }
}
