package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private static HashMap<String, Character> characters = new HashMap<>();
    private static HashMap<String, IceTable> icetables = new HashMap<>();

    static public String tab = "";
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    public static void main(String[] args) throws IOException {
        int a =1;
        int b=3;
        int c=4;

//        Direction a = new Direction(1);
//        HashMap<Direction, IceTable> neighbours = new HashMap<Direction, IceTable>();
//        IceTable it = neighbours.get(new Direction(1));
//
//        File f= new File("test.txt");
//        while (true) {
//            String line;
//            line = br.readLine();
//            System.out.println(line);
//
//            if (line.equals(""))
//                break;
//
//            String[] arguments = parseInput(line);
//            executeCommand(arguments);
//        }
//        int asda = 2;
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
                loadTestFromFiles(arguments[1]);
                break;


            case "icefield":
                String line;
                line = br.readLine();
                while (!line.contains(";")) {
                    parseNeighbours(line);
                    line = br.readLine();
                }
                parseNeighbours(line.split(";")[0]);

                break;
        }
    }

    private static void loadTestFromFiles(String fileName) throws FileNotFoundException {
//        File f= new File(fileName);
//        Scanner scanner = new Scanner(f);
//        String lines="";
//        while (scanner.hasNextLine()) {
//            String nextLine = scanner.nextLine();
//            System.out.println("x"+nextLine);
//            if (nextLine.equals("")) break;
//            lines =lines.concat(nextLine);
//        }
//        System.out.println(lines);
////        InputStream fakeIn = new ByteArrayInputStream(lines.getBytes());
////        System.setIn(fakeIn);
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
        String[] neigbours = line.split(":")[1].split(",");
        for (String elment : neigbours) {
            String direction = elment.split(" ")[0];
            String neighbourName = elment.split(" ")[1];
            if (icetables.get(neighbourName) == null)
                throw new IllegalArgumentException();
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
        if (type == 's')
            icetables.put(name, new Stable(createPickableFromID(item)));
        else if (type == 'u')
            icetables.put(name, new Unstable(createPickableFromID(item)));
        else if (type == 'h')
            icetables.put(name, new Stable(createPickableFromID(item)));
        else
            throw new IllegalArgumentException("IceTable type not found");
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


}
