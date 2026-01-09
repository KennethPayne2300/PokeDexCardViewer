package com.example.pokedexviewer;
public class Pokemon {
    private final String name, move1, move2, weakness, resistance, length, description;
    private final Double weight;
    private final int move1dmg, move2dmg, retreatCost, stage, health, pokemonImg, stageImg, typeImg;

    public Pokemon(String name, String move1, String move2, String weakness, String resistance, String description, String length, Double weight, int move1dmg, int move2dmg, int retreatCost, int stage,int health, int pokemonImg, int stageImg, int typeImg){
        this.name=name;
        this.move1=move1;
        this.move2=move2;
        this.weakness=weakness;
        this.resistance=resistance;
        this.description=description;
        this.length=length;
        this.weight=weight;
        this.move1dmg=move1dmg;
        this.move2dmg=move2dmg;
        this.retreatCost=retreatCost;
        this.stage=stage;
        this.health=health;
        this.pokemonImg=pokemonImg;
        this.stageImg=stageImg;
        this.typeImg=typeImg;
    }

    public Pokemon(String name, String move1, String move2, String weakness, String resistance, String description, String length, Double weight, int move1dmg, int move2dmg, int retreatCost, int stage,int health, int pokemonImg, int typeImg){
        this.name=name;
        this.move1=move1;
        this.move2=move2;
        this.weakness=weakness;
        this.resistance=resistance;
        this.description=description;
        this.length=length;
        this.weight=weight;
        this.move1dmg=move1dmg;
        this.move2dmg=move2dmg;
        this.retreatCost=retreatCost;
        this.stage=stage;
        this.health=health;
        this.pokemonImg=pokemonImg;
        this.stageImg=0;
        this.typeImg=typeImg;
    }

    public String getName() {
        return name;
    }

    public String getMove1() {
        return move1;
    }

    public String getMove2() {
        return move2;
    }

    public String getWeakness() {
        return weakness;
    }

    public String getResistance() {
        return resistance;
    }

    public String getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public Double getWeight() {
        return weight;
    }

    public int getMove1dmg() {
        return move1dmg;
    }

    public int getMove2dmg() {
        return move2dmg;
    }

    public int getRetreatCost() {
        return retreatCost;
    }

    public int getStage() {
        return stage;
    }

    public int getHealth() {
        return health;
    }

    public int getPokemonImg() {
        return pokemonImg;
    }

    public int getStageImg() {
        return stageImg;
    }

    public int getTypeImg() {
        return typeImg;
    }
}
