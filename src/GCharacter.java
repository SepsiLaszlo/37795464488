import java.awt.*;
import java.awt.image.BufferedImage;

public  class GCharacter implements IDrawable{
    protected BufferedImage img;
    private Character character;

    public GCharacter(Character character) {
        this.character = character;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(img, x, y, null);
    }

    public  IceTable getIceTable(){
        return character.getIceTable();
    }
}
