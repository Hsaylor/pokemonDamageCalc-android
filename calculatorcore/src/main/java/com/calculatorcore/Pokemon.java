package com.calculatorcore;

public class Pokemon {

	private String name;
	private Type[] type = new Type[2];
	private int level;
	private int baseHp;
	private int baseAtk;
	private int baseDef;
	private int baseSpAtk;
	private int baseSpDef;
	private int baseSpe;
	private int[] evs = {0, 0, 0, 0, 0, 0};
	private int[] ivs = {31, 31, 31, 31, 31, 31};
	private Nature nature;
	private Ability activeAbility;
	private Ability ability1;
	
	private Pokemon(String n, Type t1, Type t2, int hp, int atk, int def, int spatk, int spdef, int spe, Ability a){
		name = n;
		type[0] = t1;
		type[1] = t2;
		level = 50;
		nature = Nature.HARDY;
		baseHp = hp;
		baseAtk = atk;
		baseDef = def;
		baseSpAtk = spatk;
		baseSpDef = spdef;
		baseSpe = spe;
		ability1 = a;
		activeAbility = ability1;
	}
	
	//the two test pokemon for now
	//will have some sort of better organization for them once calc works
	//TODO calc works. Fix this nonsense
	
	public static Pokemon venusaur = new Pokemon("Venusaur", Type.GRASS, Type.POISON, 80, 82, 83, 100, 100, 80, Ability.OVERGROW);
	public static Pokemon tar = new Pokemon("Tyranitar", Type.ROCK, Type.DARK, 100, 134, 110, 95, 100, 61, Ability.SANDSTREAM);
	
	//getters for Pokemon
	
	public String getName(){
		return name;
	}
	
	public Type[] getType(){
		return type;
		
	}
	
	public Type getType1(){
		return type[0];
	}
	
	public Type getType2(){
		return type[1];
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getBaseHp(){
		return baseHp;
	}
	
	public int getBaseAtk(){
		return baseAtk;
	}
	
	public int getBaseDef(){
		return baseDef;
	}
	
	public int getBaseSpAtk(){
		return baseSpAtk;
	}
	
	public int getBaseSpDef(){
		return baseSpDef;
	}
	
	public int getBaseSpe(){
		return baseSpe;
	}
	
	public int getEVs(int index){
		return evs[index];
	}
	
	public int getIVs(int index){
		return ivs[index];
	}
	
	public Nature getNature(){
		return nature;
	}
	
	public void setNature(Nature n){
		nature = n;
	}
	
	public Ability getActiveAbility(){
		return activeAbility;
	}
}
