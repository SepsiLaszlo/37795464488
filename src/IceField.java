import java.util.ArrayList;
import java.util.Random;

/**
 * A jégmezőt reprezentáló osztály. Tartalmazza a jégtáblákat.
 */
public class IceField {
    private ArrayList<IceTable> iceTables = new ArrayList<IceTable>();

    /**
     * A hóvihar determinisztikus működését a paraméterben
     * megadott érték alapján tudjuk beállítani. Determinisztikus esetben minden tartalmazott
     * jégtáblára meghívja addSnow(1), majd a getUnprotectedCharacters() függvényt, és az
     * így visszakapott karaktereken meghívja a changeHeat(-1). Nem determinisztikus
     * esetben véletlenszerű táblákra futtatja le a fentebb lévő műveleteket.
     */
    public void snowStorm() {
        Random random = new Random();
        if(random.nextBoolean() && !Main.det)
            return;
        for (IceTable t : iceTables) {
            if (random.nextBoolean() || Main.det) {
                t.addSnow(1);
                ArrayList<Character> characters = t.getUnprotectedCharacters();
                if (characters == null) return;
                for (Character c : characters) {
                    c.changeHeat(-1);
                }
            }

        }
    }

    /**
     * Ezzel a függvénnyel egy jégtáblát adhatunk az
     * iceField-hez. A paraméterben kapott jégtáblát hozzáadja az iceTables adattagjához.
     * Fontos, hogy a kapott IceTable-nek a szomszédsági kapcsolatai definiálva legyenek
     * előre.
     * @param it A hozzáadandó IceTable.
     */
    public void addIceTable(IceTable it) {
        iceTables.add(it);
    }

    /**
     * Ez a függvény felszedeti a lerakott sátrakat a jégtáblákról. Egy
     * ciklusban végigmegy az iceTables összes elemén és meghívja rajtuk a setTent()
     * függvényt false paraméterrel.
     */
    public void takeTents() {
        for (IceTable t : iceTables) {
            t.setTent(false);
        }
    }
}
