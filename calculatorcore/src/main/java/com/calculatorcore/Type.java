package com.calculatorcore;

public class Type {

	private String name;
	private int index;
	
	private Type(String n, int i){
		name = n;
		index = i;
	}
	
	//2Darray for type weakness/resistance multipliers
	//
	//follows the pattern [normal, fire, water, electric, grass, ice, fighting, poison, ground, 
	//						flying, psychic, bug, rock, ghost, dragon, dark, steel, fairy]
	
	//get in the order of [defender][attacker]
	
	private static final double[][] weakChart = { 
		{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0, 1.0, 1.0, 0.5, 1.0}, 
		{1.0, 0.5, 0.5, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0}, 
		{1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0},
		{1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0},
		{1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0},
		{1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0},
		{2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 2.0, 0, 1.0, 2.0, 2.0, 0.5},
		{1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 0, 2.0},
		{1.0, 2.0, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0},
		{1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0},
		{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0, 0.5, 1.0},
		{1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5},
		{1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0},
		{0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0},
		{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 0},
		{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5},
		{1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0},
		{1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.5, 1.0}
		};

	
	//static types
	
	public static final Type NORMAL = new Type("normal", 0);
	public static final Type FIRE = new Type("fire", 1);
	public static final Type WATER = new Type("water", 2);
	public static final Type ELECTRIC = new Type("electric", 3);
	public static final Type GRASS = new Type("grass", 4);
	public static final Type ICE = new Type("ice", 5);
	public static final Type FIGHTING = new Type("fighting", 6);
	public static final Type POISON = new Type("poison", 7);
	public static final Type GROUND = new Type("ground", 8);
	public static final Type FLYING = new Type("flying", 9);
	public static final Type PSYCHIC = new Type("psychic", 10);
	public static final Type BUG = new Type("bug", 11);
	public static final Type ROCK = new Type("rock", 12);
	public static final Type GHOST = new Type("ghost", 13);
	public static final Type DRAGON = new Type("dragon", 14);
	public static final Type DARK = new Type("dark", 15);
	public static final Type STEEL = new Type("steel", 16);
	public static final Type FAIRY = new Type("fairy", 17);
	
	//getters for Types
	
	public String getName(){
		return name;
	}
	
	public int getIndex(){
		return index;
	}
	
	public double getSpecificWeaknessMultiplier(Type t2){
		return weakChart[index][t2.getIndex()];
	}
	
	public double getSpecificResistMultiplier(Type t2){
		return weakChart[t2.getIndex()][index];
	}
	
	public double calcDualTypeWeakness(Type def1, Type def2){
		
		if(def2 != null){		
			double damM = getSpecificWeaknessMultiplier(def1);
			damM = damM * weakChart[index][def2.getIndex()];
			return damM;		
		}
		
		else{
		return getSpecificWeaknessMultiplier(def1);
		}
		
	}
	
	public double calcDualTypeResist(Type second, Type attack){
		
		if(second != null){		
			double damM = getSpecificResistMultiplier(attack);
			damM = damM * weakChart[second.getIndex()][attack.getIndex()];
			return damM;		
		}
		
		else{
		return getSpecificResistMultiplier(attack);
		}
		
	}
}
