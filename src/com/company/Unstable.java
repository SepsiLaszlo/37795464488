package com.company;


public class Unstable extends IceTable {
	/**
	 * Paraméterül kap egy karaktert, amit eltárol a characters listában.
	 * @param c eltárolandó karakter
	 */
    @Override
	public void stepOn(Character c) {
	}

	/**
     * Instabil esetben nem csinál semmit a metódus.
     * @param t jégtábla, amire kimentett karaktereket helyezi
     */
	@Override
	public void removeCharacters(IceTable t) {
	}



}