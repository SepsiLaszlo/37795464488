package com.company;

import java.util.List;

public class Main {
    static public String tab = "";

    public static void main(String[] args) {
        Stable iceTable = new Stable(null);
        Eskimo e = new Eskimo(null ,iceTable);
        iceTable.stepOn(e);
        e.useAbility(iceTable);
    }
}
