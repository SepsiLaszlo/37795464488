package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Absztrakt osztály a jégtáblák reprezentálására. Ezekbe Pickable-ek lehetnek befagyva, állhat
 * rajta szereplő és boríthatja hó.
 */
public abstract class IceTable {
    protected int capacity = 1;
    private int snowLayer = 0;
    private boolean iglu = false;
    private boolean tent = false;
    private HashMap<Direction,IceTable> neighbours = new HashMap<Direction,IceTable>();
    protected ArrayList<Character> characters = new ArrayList<Character>();
    private Pickable item;

    /**
     * IceTable osztály konstruktora
     * @param p a táblán található tárgy (lehet null)
     */
    public IceTable(Pickable p) {
        item = p;
    }

    /**
     * Visszaadja a paraméterül kapott irányban lévő szomszédját.
     * @param d megadott irány
     * @return a szomszédos jégtábla
     */
    public IceTable getNeighbour(Direction d) {
       return neighbours.get(d);
    }

    /**
     * Beállítja d irányba a paraméterben kapott IceTable-t szomszédnak.
     * @param n a szomszédos jégtábla
     * @param d megadott irány
     */
    public void setNeighbour(IceTable n, Direction d) {
        neighbours.put(d,n);
    }

    /**
     * Absztrakt metódus a jégtáblák fajtájuknak megfelelően definiálják.
     * @param c táblára lépő karakter
     */
    public abstract void stepOn(Character c);

    /**
     * Paraméterül kapott karaktert eltávolítja a characters listából.
     * @param c eltávolítandó karakter
     */
    public void stepOff(Character c) {
        characters.remove(c);
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
        snowLayer = Math.max(snowLayer - amount, 0);
        if(snowLayer == 0) {
            Pickable temp = item;
            item = null;
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Paraméterül kapott értékkel növeli a snowLayer-t.
     * @param amount mennyivel kell növelni a hóréteget
     */
    public void addSnow(int amount) {
        snowLayer += amount;
    }

    /**
     * Visszaadja a rajta (jégtáblán) lévő karakterek számát.
     * @return karakterek száma
     */
    public int getCharactersNumber() {
        return characters.size();
    }

    /**
     * Visszaadja a kapacitását a jégtáblának.
     * @return kapacitás
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Iglu hozzáadása a táblához.
     */
    public void addIglu() {
        iglu = true;
    }

    /**
     * Visszaadja a táblán lévő összes karaktereket,
     * aki nincs igluban. Ha van iglu a táblán, akkor senkit (null), ha nincs akkor mindenkit,
     * tehát magát a characters listát.
     * @return szabadban lévő karakterek
     */
    public ArrayList<Character> getUnprotectedCharacters() {
        if(iglu || tent) {
            return null;
        }
        return characters;
    }

    /**
     * Sátor hozzáadása vagy levétele a tábláról. A tent tagváltozót
     * beállítja a paraméterként megadott értékre.
     * @param t beállítandó érték
     */
    public void setTent(boolean t) {
        tent = t;
    }

    /**
     * Visszaadja a táblán lévő összes Charactert,
     * aki nincs igluban. Ha van iglu a táblán, akkor senkit (null), ha nincs akkor mindenkit,
     * tehát magát a characters listát.
     * @return karakterek, akik nincsenek igluban
     */
    public ArrayList<Character> getInvadableCharacters() {
        if(iglu) {
            return null;
        }
        return characters;
    }

    /**
     * Beállítja a jégtábla kapacitását. A capacity tagváltozót
     * beállítja a paraméterben megadott értékre.
     * @param capacity beéllítandó kapacitás érték
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Visszaadja a saját adattagjait string formátumban. Az alábbi
     * formában: primitív esetben tagváltozó név: érték, egyébként tagváltozó név: típus.
     * Tömb típusú tagváltozó esetén kiírjuk a tömb nevét, és alá a tömbben lévő elemeket a
     * fentebb említett formában. Ez a metódus a tesztelést segíti.
     * @return adattagok string formátumban
     */
    public String printStat() {
        return null;
    }
}
