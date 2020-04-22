package com.company;

/**
 * A törött ásó osztálya.
 */
public class FragileSpade implements Usable,Pickable {
    /**
     * Az törött ásó maradék felhasználhatóságainak száma.
     */
    private int durability=3;

    /**
     * Az törött ásó használata. Csak akkor használható, ha a durability tagváltozó nagyobb, mint 0.
     * @param c a karakter, aki meghívja a függvényt
     * @param d a tárgy használatánk iránya
     */
    @Override
    public void use(Character c, Direction d) {
        IceTable i = c.getIceTable();
        if (durability !=0) {
            i.extract(2);
            durability--;
        }
        else{
           i.extract(0);
           System.out.println("Az ásó eltörött!");
        }

    }

     /**
     * A paraméterül kapott karakternek meghívja az addUsable(u: Usable) függvényét,
     *  amiben paraméterül saját magát adja.
     * @param c a karakter, aki el felveszi.
     */
    @Override
    public void pickUp(Character c) {
        c.addUsable(this);
    }
}
