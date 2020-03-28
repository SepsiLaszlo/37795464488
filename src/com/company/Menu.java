package com.company;

import java.security.interfaces.ECKey;
import java.util.Scanner;

public class Menu {
    private String menuItems[] = {"1. Step on Stable",
            "2. Step on Unstable",
            "3. Step on Hole",
            "4. Step off Hole",
            "5. Pick up Rope",
            "6. Pick up Spade",
            "7. Pick up Diving suite",
            "8. Pick up Food",
            "9. Pick up SignalRocketPart",
            "10. Use Rope",
            "11. Use Spade",
            "12. Use SignalRocket",
            "13. Dig",
            "14. Eskimo use ability",
            "15. Researcher use ability",
            "16. Generate snowstorm",
            "0. Exit"};

    public void writeOutMenu() {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }
    }

    public void chooseMenuItem(int menuItem) {
        System.out.println("init----------------------");
        switch(menuItem) {
            case 1: {
                Stable stable1 = new Stable(null);
                Stable stable2 = new Stable(null);
                stable1.setNeighbour(stable2, Direction.LEFT);
                stable2.setNeighbour(stable1, Direction.RIGHT);
                Eskimo e = new Eskimo(null, stable1);
                System.out.println("main----------------------");
                e.move(Direction.LEFT);
                break;
            }
            case 2: {
                Stable stable = new Stable(null);
                Unstable unstable = new Unstable(null);
                stable.setNeighbour(unstable, Direction.LEFT);
                unstable.setNeighbour(stable, Direction.RIGHT);
                Game g = Game.getInstance();
                Eskimo e = new Eskimo(g, stable);
                stable.stepOn(e);
                System.out.println("main----------------------");
                e.move(Direction.LEFT);
                break;
            }
            case 3: {
                Stable stable = new Stable(null);
                Hole hole = new Hole();
                stable.setNeighbour(hole, Direction.LEFT);
                hole.setNeighbour(stable, Direction.RIGHT);
                Eskimo e = new Eskimo(null, stable);
                stable.stepOn(e);
                System.out.println("main----------------------");
                e.move(Direction.LEFT);
                break;
            }
            case 4: {
                Hole hole = new Hole();
                Stable stable = new Stable(null);
                hole.setNeighbour(stable, Direction.LEFT);
                stable.setNeighbour(hole, Direction.RIGHT);
                Eskimo e = new Eskimo(null, hole);
                hole.stepOn(e);
                e.makeDiver();
                System.out.println("main----------------------");
                e.move(Direction.LEFT);
                break;
            }
            case 5: {
                Stable iceTable = new Stable(null);
                Eskimo e = new Eskimo(null, iceTable);
                iceTable.stepOn(e);
                System.out.println("main----------------------");
                e.useAbility(iceTable);
                break;
            }
            case 6: {
                Unstable iceTable = new Unstable(null);
                Researcher r = new Researcher(null, iceTable);
                iceTable.stepOn(r);
                System.out.println("main----------------------");
                r.useAbility(iceTable);
                break;
            }
            case 7: {
                Stable iceTable = new Stable(null);
                Eskimo e = new Eskimo(null, iceTable);
                iceTable.stepOn(e);
                iceTable.addSnow(2);
                System.out.println("main----------------------");
                e.die();
                break;
            }
            case 8: {
                Rope r = new Rope();
                Stable s = new Stable(r);
                Researcher re = new Researcher(null, s);
                s.stepOn(re);
                System.out.println("main----------------------");
                re.dig();
                break;
            }
            case 9: {
                Spade s = new Spade();
                Stable st = new Stable(s);
                Researcher r = new Researcher(null, st);
                st.stepOn(r);
                System.out.println("main----------------------");
                r.dig();
                break;
            }
            case 10: {
                DivingSuit d = new DivingSuit();
                Stable s = new Stable(d);
                Researcher r = new Researcher(null, s);
                s.stepOn(r);
                System.out.println("main----------------------");
                r.dig();
                break;
            }
            case 11: {
                Food f = new Food();
                Stable s = new Stable(f);
                Researcher r = new Researcher(null, s);
                s.stepOn(r);
                System.out.println("main----------------------");
                r.dig();
                break;
            }
            case 12: {
                SignalRocketPart srp = new SignalRocketPart();
                SignalRocket sr = new SignalRocket(null);
                Stable s = new Stable(srp);
                Researcher r = new Researcher(null, s);
                r.addUseable(sr);
                s.stepOn(r);
                System.out.println("main----------------------");
                r.dig();
                break;
            }
            case 13: {
                Stable st = new Stable(null);
                st.addSnow(3);
                Spade s = new Spade();
                Eskimo e = new Eskimo(null, st);
                st.stepOn(e);
                e.addUseable(s);
                System.out.println("main----------------------");
                e.useUseble(0);
                break;
            }
            case 14: {
                Stable s = new Stable(null);
                Hole h = new Hole();
                s.setNeighbour(h, Direction.LEFT);
                h.setNeighbour(s, Direction.RIGHT);
                Eskimo e1 = new Eskimo(null, h);
                h.stepOn(e1);
                Rope r = new Rope();
                Eskimo e2 = new Eskimo(null, s);
                s.stepOn(e2);
                e2.addUseable(r);
                System.out.println("main----------------------");
                e2.useUseble(0);
                break;
            }
            case 15: {
                Game g = Game.getInstance();
                Stable s = new Stable(null);
                Eskimo e = new Eskimo(g, s);
                s.stepOn(e);
                SignalRocket sr = new SignalRocket(g);
                e.addUseable(sr);
                System.out.println("main----------------------");
                e.useUseble(0);
                break;
            }
            case 16: {
                IceField f = new IceField();
                Stable s = new Stable(null);
                Eskimo e = new Eskimo(null, s);
                f.addIceTable(s);
                s.stepOn(e);
                System.out.println("main----------------------");
                f.snowStorm();
                break;
            }
            default: {
                System.out.println("Hibás menüpont");
            }
        }
        System.out.println("----------------------");
    }
}
