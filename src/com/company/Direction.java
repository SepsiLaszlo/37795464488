package com.company;

/**
 *  Irány a játékos mozgásához.
 */
public class Direction {
    private int name;

    public Direction(int name){
        this.name=name;

    }


    public boolean equals(Object d){
        return ((Direction)d).getName()==this.name;
    }
    public int getName() {
        return name;
    }
       @Override
    public int hashCode() {

//        String result ="";
//
//           for (char c:name.toCharArray()) {
//               int num=c;
//               result=result.concat(String.valueOf(num));
//           }

        return name;
    }

}
