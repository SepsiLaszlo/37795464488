import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

public class View extends JPanel {
    GIceTable[][] matrix;
    ArrayList<GCharacter> characters = new ArrayList<GCharacter>();
    IDrawable message;

    private List<Object> getRandomPickable() {
        int rand = new Random().nextInt(10);
        switch (rand) {
            case 0:
                return Arrays.asList(new DivingSuit(), new GPickable("divingsuite.png"));
            case 1:
                return Arrays.asList(new Food(), new GPickable("food.png"));
            case 2:
                return Arrays.asList(new FragileSpade(), new GPickable("spade.png"));
            case 3:
                return Arrays.asList(new Rope(), new GPickable("rope.png"));
            case 4:
                return Arrays.asList(new Spade(), new GPickable("spade.png"));
            case 5:
                return Arrays.asList(new Tent(), new GPickable("tent.png"));
            default:
                return Arrays.asList(null, null);
        }
    }

    private GIceTable getRandomIceTable(Pickable p, GPickable gp) {
        int rand = new Random().nextInt(5);
        switch (rand) {
            case 0:
                return new GHole(new Hole());
            case 1:
                return new GNormalTable(new Unstable(p), gp);
            default:
                return new GNormalTable(new Stable(p), gp);
        }
    }

    public IceField init(int row, int column) {
        Random r = new Random();
        HashSet<Integer> signalRocketPartPlace = new HashSet<>();
        while(signalRocketPartPlace.size() < 3) {
            int rand = r.nextInt(row * column);
            signalRocketPartPlace.add(rand);
        }

        matrix = new GIceTable[row][column];
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++) {
                List<Object> pickables = getRandomPickable();
                Pickable pickable = (Pickable)pickables.get(0);
                GPickable gPickable = (GPickable)pickables.get(1);
                GIceTable gIceTable = getRandomIceTable(pickable, gPickable);
                if(signalRocketPartPlace.contains(i * column + j)) {
                    pickable = new SignalRocketPart();
                    gPickable = new GPickable("signalrocketpart.png");
                    gIceTable = new GNormalTable(new Stable(pickable), gPickable);
                }
                matrix[i][j] = gIceTable;
            }
        }

        IceField iceField = new IceField();
        for(int i = 0;i < row;i++) {
            for (int j = 0; j < column; j++) {
                IceTable it = matrix[i][j].getIceTable();
                it.setNeighbour(matrix[(i - 1 + row) % row][j].getIceTable(), new Direction(0));
                it.setNeighbour(matrix[(i + 1) % row][j].getIceTable(), new Direction(2));
                it.setNeighbour(matrix[i][(j - 1 + column) % column].getIceTable(), new Direction(3));
                it.setNeighbour(matrix[i][(j + 1) % column].getIceTable(), new Direction(1));
                it.addSnow(r.nextInt(3));
                iceField.addIceTable(it);
            }
        }
        return iceField;
    }

    public void drawAll() {
        repaint();
    }

    public void addCharacter(GCharacter gc) {
        characters.add(gc);
    }

    public void endSceneDraw(boolean win) {
        matrix = null;
        characters.clear();
        if(win) {
            showDialog("You Won The Game!");
        } else {
            showDialog("You Lose The Game!");
        }
    }

    public void showDialog(String s) {
        message = (g, x, y) -> {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.black);
            g2.setFont(new Font("Consolas", Font.BOLD, 26));

            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(s, g2);

            x = (getWidth() - (int) r.getWidth()) / 2;
            y = ((getHeight() - (int) r.getHeight()) / 3 + fm.getAscent());

            g2.drawString(s, x, y);

            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        };

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                message = null;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0;i < matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j].draw(g, 128 * j, 128 * i);
                for (GCharacter gc : characters) {
                    if(matrix[i][j].getIceTable() == gc.getIceTable()) {
                        gc.draw(g, 128 * j, 128 * i);
                    }
                }
            }
        }

        if(message != null) {
            message.draw(g, 0, 0);
        }
    }
}
