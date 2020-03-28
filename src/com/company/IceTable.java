package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class IceTable {
    private int capacity;
    private int snowLayer;
    private boolean iglu;
    private HashMap<Direction,IceTable> neighbours = new HashMap<Direction,IceTable>();
    protected ArrayList<Character> characters=new ArrayList<Character>();
    private Pickable item;

    /**
     * IceTable osztály konstruktora
     * @param p a táblán található tárgy (lehet null)
     */
    public IceTable(Pickable p) {
        item=p;
    }

    /**
     * Az adott irányból lekérdezi a jégtábla szomszédját.
     * @param d megadott irány
     * @return a szomszédos jégtábla
     */
    public IceTable getNeighbour(Direction d) {
        System.out.println(Main.tab + ">IceTable.getNeighbour(Direction)");
        System.out.println(Main.tab + "<IceTable.getNeighbour(Direction)");
        return neighbours.get(d);
    }

    /**
     * Az adott irányba beállítja, hogy a jégtábla szomszédját.
     * @param d megadott irány
     * @param n a szomszédos jégtábla
     */
    public void setNeighbour(IceTable n, Direction d) {
            neighbours.put(d,n);
    }


    /**
     * Paraméterül kap egy karaktert, amit eltárol a characters listában,
     * @param c eltárolandó karakter
     */
    public abstract void stepOn(Character c);

    /**
     * Paraméterül kapott karaktert eltávolítja a characters listából.
     * @param c eltávolítandó karakter
     */
    public void stepOff(Character c) {
        System.out.println(Main.tab + ">IceTable.stepOff(Character)");
        System.out.println(Main.tab + "<IceTable.stepOff(Character)");
    }

    /**
     * Minden karaktert a characters listából áthelyez a paraméterben kapott IceTable-re.
     * A kötél hívja meg, de csak lukban lévő karakterekre érvényes.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
    public abstract void removeCharacters(IceTable t);

    /**
     * Paraméterül kapott mennyiséggel csökkenti a snowLayer értékét.
     * Ha az nagyobb, mint 0, vagy ha nincs rajta tárgy null-t ad vissza.
     * Egyébként pedig az eltárolt felvehető tárgyat.
     * @param amount mennyivel kell csökkenteni a hóréteget
     * @return eltárolt felvehető tárgy
     */
    public Pickable extract(int amount) {
        System.out.println(Main.tab + ">IceTable.extract(1)");
        System.out.println(Main.tab + "Pickable <IceTable.extract(1)");
        return null;
    }

    /**
     * Paraméterül kapott értékkel növeli a snowLayer-t.
     * @param amount mennyivel kell növelni a hóréteget
     */
    public void addSnow(int amount) {
        System.out.println(Main.tab + ">IceTable.addSnow(1)");
        System.out.println(Main.tab + "<IceTable.addSnow(1)");
    }

    /**
     * Visszaadja a rajta (jégtáblán) lévő karakterek számát.
     * @return karakterek száma
     */
    public int getCharactersNumber() {
        System.out.println(Main.tab + ">IceTable.getCharactersNumber()");
        System.out.println(Main.tab + "int <IceTable.getCharactersNumber()");

        return 0;
    }

    /**
     * Visszaadja a kapacitását a jégtáblának.
     * @return kapacitás
     */
    public int getCapacity() {
        System.out.println(Main.tab + ">IceTable.getCapacity()");
        System.out.println(Main.tab + "int <IceTable.getCapacity()");
        return 0;
    }

    /**
     * Iglu hozzáadása a táblához.
     */
    public void addIglu() {
        System.out.println(Main.tab + ">IceTable.addIglu()");
        System.out.println(Main.tab + "<IceTable.addIglu()");
    }

    /**
     * Visszaadja a táblán lévő összes Charactert, aki nincs igluban.
     *
     * @return szabadban lévő karakterek
     */
    public ArrayList<Character> getUnprotectedCharacters() {
        System.out.println(Main.tab + ">IceTable.getUnprotectedCharacters()");
        System.out.println(Main.tab + "Character[] <IceTable.getUnprotectedCharacters()");

        return characters;
    }

}
