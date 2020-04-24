package com.company;

import java.util.Random;

/**
 * A jegesmedvét reprezentáló osztály.
 * Összesen egy darab van belőle. Felelőssége a mozgás
 * véletlenszerű irányba és a többi játékos elkapása.
 */
public class PolarBear extends Character {
    private boolean deterministic;

    /**
     * A PolarBear osztály konstruktora.
     *
     * @param i Erre a jégtáblára lépteti a szereplőt.
     * @param det A jegesmedve lépése determinisztikus-e.
     */
    public PolarBear(IceTable i, boolean det) {
        super(i);
        workUnit = 1;
        initialWorkUnit = 1;
        deterministic = det;
        diver = true;
    }

    /**
     * Jegesmedve esetén nem használjuk
     */
    @Override
    public void addUsable(Usable u) { }

    /**
     * Jegesmedve esetén nem használjuk
     */
    @Override
    public void useUsable(int idx){ }

    /**
     * Jegesmedve esetén nem használjuk
     */
    public void changeHeat(int diff){ }

    /**
     * Jegesmedve esetén nem használjuk
     */
    @Override
    public void buildSignalRocket(SignalRocketPart s) { }

    /**
     * A jegesmedve képessége, hogy a vele egy táblán és nem
     * igluban lévő karaktereket elkapja és megöli. A saját jégtábláján (iceTable tagváltozó)
     * meghívja a getInvadableCharacters() függvényt. Ha ennek a visszatérési értéke nem
     * null, akkor a visszatérési értékben kapott karaktereken meghívja a die() metódust.
     * @param t A jégtábla.
     * @return 0.
     */
    @Override
    public int useAbility(IceTable t) {
        Character[] charactersToInvade = getIceTable().getInvadableCharacters();
        if (charactersToInvade != null)
            for (Character character : charactersToInvade)
                character.die();
        return 0;
    }

    /**
     * A szereplő léptetése ‘d’ irányba.
     * @param d Az irány.
     */
    public void move(Direction d) {
        if (!deterministic)
            d = new Direction(new Random().nextInt(6));
        super.move(d);
    }

    /**
     * Jegesmedve esetén nem használjuk
     */
    @Override
    public void dig() { }

    /**
     * A karakter elkap másik karaktereket a jégtáblán,
     * amin áll. Meghívja a useAbility(IceTable t) függvényt saját magán.
     */
    @Override
    public void invadeOtherCharacters() {
        useAbility(getIceTable());
    }

    /**
     * Jegesmedve esetén nem használjuk
     */
    @Override
    public void pass() { }
}
