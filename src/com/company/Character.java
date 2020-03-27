package com.company;

import java.util.ArrayList;

/**
 * Absztrakt osztály. A felhasználó által irányított szereplőket reprezentáló osztály (pl. eszkimó,
 * sarkkutató). Felelősségei többek közt a mozgás, munkavégzés.
 */
public abstract class Character {
    /**
     * A hátralévő munkaegységek száma az adott körben.
     */
    private int workUnit;
    /**
     * A szereplő testhőjének mértéke.
     */
    private int bodyTemperature;
    /**
     * A szereplő visel-e búvárruhát.
     */
    private boolean diver;
    /**
     * A szereplő vízben van-e.
     */
    private boolean inWater;
    /**
     * Ezen a jégtáblán áll a szereplő.
     */
    private IceTable iceTable;
    /**
     * A jelzőrakéta.
     */
    private SignalRocket signalRocket;
    /**
     * A játék osztály.
     */
    private Game game;
    /**
     * A szereplő által birtokolt tárgyak.
     */
    private ArrayList<Useable> useables;

    /**
     * A karakter osztály konstruktora.
     * @param g A játék osztály.
     * @param i Erre a jégtáblára lépteti a szereplőt.
     */
    public Character(Game g, IceTable i){}

    /**
     * Az eltárolandó tárgyak által hívott függvény, amely
     * felveszi useables listába az adott Useable-t.
     * @param u Az eltárolandó tárgy.
     */
    public void addUseable(Useable u){}

    /**
     * A useables listának az adott indexű Useable-jét használja.
     * @param idx Az index.
     */
    public void useUseable(int idx){}

    /**
     * A testhő megváltozására használható metódus. A
     * paraméterben kapott számot adja testhőhöz.
     * @param diff A hozzáadandó testhő mértéke.
     */
    public void changeHeat(int diff){}

    /**
     * A búvárruha felvételekor meghívandó metódus. A diver értéket
     * állítja true-ra.
     */
    public void makeDiver(){}

    /**
     * A paraméterként kapott alkatrészt hozzáadja a
     * SignalRocket-hoz.
     * @param i Az alkatrész.
     */
    public void buildSignalRocket(Pickable i){}

    /**
     * Absztrakt függvény a karakter speciális képességének
     * használatára a paraméterben kapott táblán.
     * @param t A jégtábla.
     */
    public abstract int useAbility(IceTable t);

    /**
     * A szereplő léptetése ‘d’ irányba.
     * @param d Az irány.
     */
    public void move(Direction d){}

    /**
     * A szereplő beleesik a vízbe.
     */
    public void fallInWater(){}

    /**
     * A szereplő meghal.
     */
    public void die(){}

    /**
     * A szereplő ás azon a jégtáblán, amelyen éppen áll.
     */
    public void dig(){}

    /**
     * Visszaadja a táblán, amin tartózkodik.
     * @return A jégtábla, amelyen áll.
     */
    public IceTable getIceTable(){ return iceTable; }

    /**
     * A szereplő kijön a víből.
     */
    public void comeOutOfWater(){}
}
