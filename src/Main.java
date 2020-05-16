import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;



public class Main {
    static boolean det = false;

    public static void main(String[] args) {
    Window window = new Window();

    Game.getInstance().setupGame(1,1);
    window.runGame();
        }
    }

