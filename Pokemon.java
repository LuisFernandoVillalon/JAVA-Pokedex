package com.example.main;

public class Pokemon {

    public String num;
    public String name;
    public String type1;
    public String type2;

    Pokemon(String[] pokeData) {
        num = pokeData[0].replace("\"", "");
        name = pokeData[1].replace("\"", "");
        type1 = pokeData[2].replace("\"", "");
        type2 = pokeData[3].replace("\"", "");
    }

    public String getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
    public String getType1() {
        return type1;
    }
    public String getType2() {
        return type2;
    }

}
