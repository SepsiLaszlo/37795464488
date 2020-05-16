/**
 * Az eszkimó típusú karaktert reprezentáló osztály.
 * Különleges képessége, hogy tud iglut építeni.
 */
public class Eskimo extends Character {
    /**
     * Az eszkimó osztály konstruktora. Meghívja a Character ősosztály konstruktorát.
     * @param i Erre a jégtáblára lépteti a szereplőt.
     */
    public Eskimo(IceTable i) {
        super(i);
        bodyTemperature = 5;
        workUnit = 4;
        initialWorkUnit = 4;
    }

    /**
     * A paraméterben kapott táblára épít egy iglut.
     * @param t A jégtábla.
     * @return 0, nem használandó.
     */
    @Override
    public int useAbility(IceTable t) {
        getIceTable().addIglu();
        workUnit--;
        if (workUnit == 0) {
            game.nextPlayer();
            workUnit = initialWorkUnit;
        }
        return 0;
    }

    /**
     * Ez a függvény üresen kerül definiálásra az eszkimó
     * részéről.
     */
    @Override
    public void invadeOtherCharacters() { }

    /**
     * Visszaadja a saját adattagjait string formátumban. Az alábbi
     * formában: primitív esetben tagváltozó név: érték, egyébként tagváltozó név: típus.
     * Tömb típusú tagváltozó esetén kiírjuk a tömb nevét, és alá a tömbben lévő elemeket a
     * fentebb említett formában.
     * @return adattagok string formátumban
     */
    public String  toString(){
        return  "Eskimo\n"+super.toString();
    }
}