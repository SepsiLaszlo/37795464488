import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

/**
 * Az MVC model megjelenítéséért felelős részét, megvalósító osztály.
 */
public class View extends JPanel {
    GIceTable[][] matrix;
    ArrayList<GCharacter> characters = new ArrayList<GCharacter>();
    IDrawable message;

    /**
     * Egy véletlenszerű tárgyal és a hozzá tartozó nézettel tér vissza.
     * @return A tárgy és a hozzá tartozó nézet.
     */
    private List<Object> getRandomPickable() {
        int rand = new Random().nextInt(10);
        switch (rand) {
            case 0:
                return Arrays.asList(new DivingSuit(), new GPickable("divingsuite.png", false));
            case 1:
                return Arrays.asList(new Food(), new GPickable("food.png", false));
            case 2:
                return Arrays.asList(new FragileSpade(), new GPickable("spade.png", true));
            case 3:
                return Arrays.asList(new Rope(), new GPickable("rope.png", true));
            case 4:
                return Arrays.asList(new Spade(), new GPickable("spade.png", true));
            case 5:
                return Arrays.asList(new Tent(), new GPickable("tent.png", true));
            default:
                return Arrays.asList(null, null);
        }
    }

    /**
     * Egy véletlenszerű jégtáblát típust generál, amit felparaméterez, hozzárendeli a típusának
     * megfelelő nézeti osztályához és visszatér vele.
     * @param charactersNumber A játékban résztvevő karakterek száma.
     * @return A jégtáblához tartozó nézeti osztály.
     */
    private GIceTable getRandomIceTable(int charactersNumber) {
        Random r = new Random();
        switch (r.nextInt(5)) {
            case 0: {
                return new GHole(new Hole()); }
            case 1: {
                List<Object> pickables = getRandomPickable();
                Unstable unstable = new Unstable((Pickable)pickables.get(0));
                unstable.setCapacity(r.nextInt(charactersNumber - 2) + 2);
                return new GNormalTable(unstable, (GPickable)pickables.get(1)); }
            default: {
                List<Object> pickables = getRandomPickable();
                Stable stable = new Stable((Pickable)pickables.get(0));
                stable.setCapacity(charactersNumber + 1);
                return new GNormalTable(stable, (GPickable)pickables.get(1)); }
        }
    }

    /**
     * A paraméterben átadott mérető véletlenszerű jégmezőt generál, a jégtáblákban véletlenszerű tárgyakkal, a
     * hozzá tartozó nézeteikkel együtt.
     * Ezután létrehozza a karaktereket azok nézeteivel és a jegesmedve kivételével elhelyezi őket az első
     * jégtáblán. A jegesmedvét egy ettől különböző véletlenszerű jégtáblára helyezi.
     * @param row A jégmező sorainak a száma.
     * @param column A jégmező oszlopainak a száma.
     * @param eskimo Az eszkimók száma.
     * @param researcher A kutatók száma.
     * @return A létrehozott jégmező.
     */
    public IceField init(int row, int column, int eskimo, int researcher) {
        Random r = new Random();
        //A jelzőrakéta alkatrészek helyeinek meghatározása.
        HashSet<Integer> signalRocketPartPlace = new HashSet<>();
        while(signalRocketPartPlace.size() < 3) {
            int rand = r.nextInt(row * column - 1) + 1;
            signalRocketPartPlace.add(rand);
        }

        //A pálya legenerálása.
        matrix = new GIceTable[row][column];
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++) {
                if(i == 0 && j == 0)
                    continue;
                GIceTable gIceTable = getRandomIceTable(eskimo + researcher + 1);
                if(signalRocketPartPlace.contains(i * column + j)) {
                    gIceTable = new GNormalTable(new Stable(new SignalRocketPart()), new GPickable("signalrocketpart.png", false));
                }
                matrix[i][j] = gIceTable;
            }
        }
        //A játékosok legenerálása és ráhelyezése a pálya első mezőjére.
        List<Object> pickables = getRandomPickable();
        matrix[0][0] = new GNormalTable(new Stable((Pickable)pickables.get(0)), (GPickable)pickables.get(1));
        for(int i = 0;i < eskimo;i++) {
            characters.add(new GEskimo(new Eskimo(matrix[0][0].getIceTable())));
        }
        for(int i = 0;i < researcher;i++) {
            characters.add(new GResearcher(new Researcher(matrix[0][0].getIceTable())));
        }
        //A jegesmedve elhelyezése
        characters.add(new GPolarBear(new PolarBear(matrix[r.nextInt(row - 1) + 1][r.nextInt(column - 1) + 1].getIceTable())));

        //A szomszédsági viszonyok létrehozása a jégtáblák között.
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

    /**
     * A panel, és az azon lévő összes elem újrarajzolása.
     */
    public void drawAll() {
        repaint();
    }

    /**
     * Kirajzolja a játék végén az eredményt jelző ablakot.
     * @param win A játék végeredménye.
     */
    public void drawEndScene(boolean win) {
        matrix = new GIceTable[0][0];
        characters.clear();
        if(win) {
            showDialog("You Won The Game!");
        } else {
            showDialog("You Lose The Game!");
        }
        repaint();

        Object syncObject = new Object();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                synchronized(syncObject) {
                    syncObject.notify();
                }
                repaint();
                removeMouseListener(this);
            }
        });

        synchronized(syncObject) {
            try {
                syncObject.wait();
            } catch (InterruptedException e) { }
        }
    }

    /**
     * A paraméterben átadott üzenet kirajzolása/megjelenítése.
     * @param s üzenet
     */
    public void showDialog(String s) {
        message = (g, x, y) -> {
            String msg = s;
            g.setColor(Color.black);
            g.setFont(new Font("Consolas", Font.BOLD, 26));

            FontMetrics fm = g.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(msg, g);

            y = ((getHeight() - (int) r.getHeight()) / 3 + fm.getAscent());

            for (String line : msg.split("\n")) {
                r = fm.getStringBounds(line, g);

                x = (getWidth() - (int) r.getWidth()) / 2;
                y += fm.getHeight();

                g.drawString(line, x, y);
            }

            msg = "<Click>";
            g.setFont(new Font("Consolas", Font.BOLD, 12));

            fm = g.getFontMetrics();
            r = fm.getStringBounds(msg, g);

            x = (getWidth() - (int) r.getWidth()) / 2;
            y += r.getHeight() + fm.getAscent();

            g.drawString(msg, x, y);
        };


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                message = null;
                repaint();
                removeMouseListener(this);
            }
        });
    }

    /**
     * A jégmezőt, az azon lévő összes elemet, a karakterekhez tartozó inventorit, valamint
     * az információt tartalmazó üzeneteket rajzolja ki a panelre.
     * @param g Az objektum, amire kirajzolja magát.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int startX = 0, startY = 80;
        for(int i = 0;i < matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                GPickable gp = matrix[i][j].checkItemPickup();
                matrix[i][j].draw(g, startX + 128 * j, startY + 128 * i);
                for (GCharacter gc : characters) {
                    if(matrix[i][j].getIceTable() == gc.getIceTable()) {
                        gc.draw(g, startX + 128 * j, startY + 128 * i);
                        if(gc.getCharacter() == Game.getInstance().getCurrCharacter())
                            gc.addItem(gp);
                    }
                }
            }
        }

        int id = 1;
        for (GCharacter gc : characters) {
            if (gc.getCharacter() == Game.getInstance().getCurrCharacter()) {
                gc.drawInventory(g, startX, startY - 80, id);
                break;
            }
            id++;
        }

        if(message != null) {
            message.draw(g, 0, 0);
        }
    }
}
