package com.company;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static public String tab = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        int menuItem = -1;
        menu.writeOutMenu();
        while(menuItem != 0) {
            System.out.print("Menüpont száma: ");
            try {
                menuItem = in.nextInt();
            }
            catch (InputMismatchException ime) {
                in.nextLine();
                menuItem = -1;
            }
            finally {
                menu.chooseMenuItem(menuItem);
            }
        }
        in.close();
    }
}
