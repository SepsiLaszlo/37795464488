package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private static HashMap<String, Character> characters = new HashMap<>();
    private static HashMap<String, IceTable> icetables = new HashMap<>();

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static Scanner scanner = new Scanner(System.in);
    private static IceField iceField = new IceField();
    private static String output;
    public static  boolean det = true;
    public static  Direction usableDir = null;

    public static void main(String[] args) throws IOException {
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

    private static void executeCommand(String[] arguments) throws IOException {

        switch (arguments[0]) {

            case "icetable":
                buildIceTable(arguments[2], arguments[1].charAt(0), arguments[1].charAt(1));
                break;

            case "eskimo":
                buildCharacter(arguments[1], arguments[0], arguments[2]);
                break;

            case "researcher":
                buildCharacter(arguments[1], arguments[0], arguments[2]);
                break;

            case "polarbear":
                buildCharacter(arguments[1], arguments[0], arguments[2]);
                break;

            case "dig":
                digWithCharacter(arguments[1]);
                break;

            case "delete":
                characters.remove(arguments[1]);
                icetables.remove(arguments[1]);
                break;

            case "load":
                load(arguments[1]);
                break;

            case "icefield":
                readNeighbours(scanner);
                break;
            case "useability":
                useAbility(arguments[1], arguments[2]);
                break;
            case "move":
                moveCharcter(arguments[1], arguments[2]);
                break;
            case "useusable":
                if ( arguments.length == 4 ) {
                    usableDir = new Direction( Integer.parseInt(arguments[3].substring(1)) );
                }
                characterUse(arguments[1], Integer.parseInt(arguments[2]));
                break;
            case "reset":
                reset();
                break;
            case "stat":
                stat(arguments[1]);
                break;
            case "setcapacity":
                icetables.get(arguments[1]).setCapacity(Integer.parseInt(arguments[2]));
                break;
            case "snowstorm":
                iceField.snowStorm();
                break;
            case "addsnow":
                icetables.get(arguments[1]).addSnow(Integer.parseInt(arguments[2]));
                break;
            case "testall":
                int successTests = 0;
                for ( int i = 1; i <= 27; i++ ) {
                    if ( load("test" + i + ".txt") ) {
                        successTests++;
                    } else {
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                        System.out.println("===================================================");
                    }
                    reset();
                }
                System.out.println(
                        "Result: " + successTests + "/27" +
                        ((successTests == 27) ? " :)" : " :(")
                );
                break;
        }
    }

    private static boolean load(String fileName) throws IOException {
        executeCommandsInFile(fileName);
        String[] t= fileName.split("\\.");
        String expected= t[0]+"out.txt";
        return compareOutputToInput(output,expected);
    }

    private static void reset() {
        characters = new HashMap<>();
        icetables = new HashMap<>();
        iceField = new IceField();
        Game.getInstance().reset();
    }

    private static void useAbility(String characterName, String tableName) {
        Character character = characters.get(characterName);
        if (character == null)
            throw new IllegalArgumentException("Character not found");
        IceTable iceTable = icetables.get(tableName);
        if (iceTable == null)
            throw new IllegalArgumentException("Icetable not found");
        character.useAbility(iceTable);
    }

    private static void readNeighbours(Scanner s) throws IOException {
        String line;
        line = s.nextLine();
        while (!line.contains(";")) {
            parseNeighbours(line);
            line = s.nextLine();
        }
        parseNeighbours(line.split(";")[0]);
    }

    private static void executeCommandsInFile(String fileName) throws IOException {
        output = "";

        File f = new File("tests/" + fileName);
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();

            if (nextLine.equals("")) break;
            String[] arguments = parseInput(nextLine);
            if (arguments[0].equals("icefield")) {
                readNeighbours(scanner);
            } else {
                executeCommand(arguments);
            }

        }
    }


    private static void digWithCharacter(String argument) {
        Character character = characters.get(argument);
        if (character == null)
            throw new IllegalArgumentException("Character not found");
        character.dig();
    }

    public static void parseNeighbours(String line) {
        String baseTableName = line.split(":")[0];
        if (icetables.get(baseTableName) == null)
            throw new IllegalArgumentException();
        IceTable baseTable = icetables.get(baseTableName);
        String[] neigbours = line.split(":")[1].split(", ");
        for (String elment : neigbours) {
            String direction = elment.split(" ")[0];
            String neighbourName = elment.split(" ")[1];
            if (icetables.get(neighbourName) == null)
                throw new IllegalArgumentException("Not found: " + neighbourName);
            IceTable neighbour = icetables.get(neighbourName);
            addNeighbour(baseTable, neighbour, direction);
        }
    }

    public static void addNeighbour(IceTable base, IceTable neighbour, String dir) {
        base.setNeighbour(neighbour, new Direction(Integer.parseInt(dir.substring(1))));
    }

    public static void buildCharacter(String name, String type, String iceTableName) {

        if (icetables.get(iceTableName) == null)
            throw new IllegalArgumentException("IceTable not found");
        if (type.equals("eskimo"))
            characters.put(name, new Eskimo(icetables.get(iceTableName)));
        if (type.equals("researcher"))
            characters.put(name, new Researcher(icetables.get(iceTableName)));
        if (type.equals("polarbear"))
            characters.put(name, new PolarBear(icetables.get(iceTableName)));

    }

    public static void buildIceTable(String name, char type, char item) throws IllegalArgumentException {
        IceTable iceTable;
        if (type == 's')
            iceTable = new Stable(createPickableFromID(item));
        else if (type == 'u')
            iceTable = new Unstable(createPickableFromID(item));
        else if (type == 'h')
            iceTable = new Hole();
        else
            throw new IllegalArgumentException("IceTable type not found");
        icetables.put(name, iceTable);
        iceField.addIceTable(iceTable);
    }

    public static Pickable createPickableFromID(char id) throws IllegalArgumentException {
        switch (id) {
            case 'o':
                return new Food();


            case 'r':
                return new Rope();


            case 's':
                return new Spade();


            case 'f':
                return new FragileSpade();


            case 'd':
                return new DivingSuit();


            case 't':
                return new Tent();


            case 'p':
                return new SignalRocketPart();


            case 'e':
                return null;


            default:
                throw new IllegalArgumentException("Pickable type not found: " + id);
        }
    }

    private static String[] parseInput(String line) {
        String[] arguments = line.split(" ");
        return arguments;
    }


    private static void stat(String argument) {
        String result = "";
        switch (argument) {
            case "signalRocket":
                result = SignalRocket.getInstance().toString();
                break;
            case "game":
                result = Game.getInstance().toString();
                break;
            default:
                Character character = characters.get(argument);
                IceTable it = icetables.get(argument);
                if (character != null) {
                    result = character.toString();
                } else if (it != null) {
                    result = it.toString();
                }
                break;
        }
        System.out.println(result + "\n");
        output = output.concat(result + "\n\n");

    }

    private static void characterUse(String c, int usable) {
        Character character = characters.get(c);
        if (character == null)
            throw new IllegalArgumentException("Character not found");
        character.useUsable(usable);
    }

    private static void moveCharcter(String c, String dir) {
        Character character = characters.get(c);
        if (character == null)
            throw new IllegalArgumentException("Character not found");
        character.move(new Direction(Integer.parseInt(dir.substring(1))));
    }

    public static String getCharacterNameFromObject(Character character) {
        for (HashMap.Entry<String, Character> entry : characters.entrySet()) {
            if (entry.getValue() == character) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static String getIceTableNameFromObject(IceTable it) {
        for (HashMap.Entry<String, IceTable> entry : icetables.entrySet()) {
            if (entry.getValue() == it) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static boolean compareOutputToInput(String output, String filename) throws FileNotFoundException {
        File file = new File("tests/" + filename);
        Scanner scanner = new Scanner(file);
        System.out.println("Testing: "+filename);
        for (String actual : output.split("\n")) {
            String expected = scanner.nextLine();
            if (!expected.equals(actual)) {
                System.out.println("Actual:");
                System.out.println(actual);
                System.out.println("=====================");
                System.out.println("Expected:");
                System.out.println(expected);

                return false;
            }
        }
        System.out.println("MATCH");
        return true;
    }

}
