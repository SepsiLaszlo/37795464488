import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;



public class Main {
    static boolean det = false;

    public static void main(String[] args) {
        Window window = new Window();
        window.addKeyListener(new KeyEventHeandler(new Controller()));
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String line;
            line = s.nextLine();

            if (line.equals(""))
                break;

            String[] arguments = parseInput(line);
            executeCommand(arguments);
            reset();
        }
    }

