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
    protected int bodyTemperature;
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
    private ArrayList<Usable> usables;

    /**
     * A karakter osztály konstruktora.
     * @param g A játék osztály.
     * @param i Erre a jégtáblára lépteti a szereplőt.
     */
    public Character(Game g, IceTable i) {
        game = g;
        iceTable = i;
    }

    /**
     * Az eltárolandó tárgyak által hívott függvény, amely
     * felveszi usebles listába az adott Useble-t.
     * @param u Az eltárolandó tárgy.
     */
    public void addUsable(Usable u){
        System.out.println(Main.tab + ">Character.addUsable(Usable)");
        Main.tab += "\t";

        usables.add(u);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.addUsable(Usable)");
    }

    /**
     * A usebles listának az adott indexű Useable-jét használja.
     * @param idx Az index.
     */
    public void useUsable(int idx){
        System.out.println(Main.tab + ">Character.useUsable(" + idx + ")");
        Main.tab += "\t";

        usables.get(idx).use(this, null);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.useUsable(" + idx + ")");
    }

    /**
     * A testhő megváltozására használható metódus. A
     * paraméterben kapott számot adja testhőhöz.
     * @param diff A hozzáadandó testhő mértéke.
     */
    public void changeHeat(int diff){
        System.out.println(Main.tab + ">Character.changeHeat(" + diff + ")");
        Main.tab += "\t";

        bodyTemperature += diff;
        if (bodyTemperature <= 0)
            game.endGame(false);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.changeHeat(" + diff + ")");
    }

    /**
     * A búvárruha felvételekor meghívandó metódus. A diver értéket
     * állítja true-ra.
     */
    public void makeDiver(){
        System.out.println(Main.tab + ">Character.makeDiver()");
        Main.tab += "\t";

        diver = true;

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.makeDiver()");
    }

    /**
     * A paraméterként kapott alkatrészt hozzáadja a
     * SignalRocket-hoz.
     * @param s Az alkatrész.
     */
    public void buildSignalRocket(SignalRocketPart s){
        System.out.println(Main.tab + ">Character.buildSignalRocket(SignalRocketPart)");
        Main.tab += "\t";

        signalRocket.build(s);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.buildSignalRocket(SignalRocketPart)");
    }

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
    public void move(Direction d) {
        System.out.println(Main.tab + ">Character.move(Direction)");
        Main.tab += "\t";

        IceTable i = iceTable.getNeighbor(d);
        iceTable.stepOff(this);
        i.stepOn(this);
        iceTable = i;

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.move(Direction)");
    }

    /**
     * A szereplő beleesik a vízbe.
     */
    public void fallInWater(){
        System.out.println(Main.tab + ">Character.fallInWater()");
        Main.tab += "\t";

        if (!diver) {
            inWater = true;
            game.nextPlayer();
        }

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.fallInWater()");
    }

    /**
     * A szereplő meghal.
     */
    public void die(){
        System.out.println(Main.tab + ">Character.die()");
        Main.tab += "\t";

        game.endGame(false);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.die()");
    }

    /**
     * A szereplő ás azon a jégtáblán, amelyen éppen áll.
     */
    public void dig(){
        System.out.println(Main.tab + ">Character.dig()");
        Main.tab += "\t";

        Pickable p = iceTable.extract(1);
        if (p != null)
            p.pickUp(this);

        Main.tab = Main.tab.substring(0, Main.tab.length() - 1);
        System.out.println(Main.tab + 0 + "<Character.dig()");
    }

    /**
     * Visszaadja a táblán, amin tartózkodik.
     * @return A jégtábla, amelyen áll.
     */
    public IceTable getIceTable() {
        System.out.println(Main.tab + ">Character.fallInWater()");
        System.out.println(Main.tab + 0 + "<Character.fallInWater()");
        return iceTable;
    }

    /**
     * A szereplő kijön a víből.
     */
    public void comeOutOfWater() {
        System.out.println(Main.tab + ">Character.comeOutOfWater()");
        inWater = false;
        System.out.println(Main.tab + 0 + "<Character.comeOutOfWater()");
    }
}
