/**
 * A stabil jégtáblák reprezentálására. Ezekbe Pickable-ek lehetnek befagyva, állhat rajta
 * szereplő és boríthatja hó.
 */
public class Stable extends IceTable {

    /**
	 * Stable osztály konstruktora
	 * @param p a táblán található tárgy (lehet null)
	 */
    public Stable(Pickable p){
        super(p);
    }

    /**
	 * Paraméterül kap egy karaktert, amit eltárol a characters
     * listában. Ezután minden karakteren meghívja az invadeOtherCharacters() függvényt.
	 * @param c táblára lépő karakter
	 */
    @Override
    public void stepOn(Character c) {
        characters.add(c);
        for (Character character: characters) {
            character.invadeOtherCharacters();
        }
    }

    /**
     * Stabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    @Override
    public void removeCharacters(IceTable t) {
    }
}