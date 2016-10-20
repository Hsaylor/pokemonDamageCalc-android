package com.saylor.harrison.pokemondamagecalc.core;

public class Attack {

	private String name;
	private double basePower;
	private Type type;
	private boolean physical;
	private boolean spread;
	private boolean contact;

	private Attack(String n, double bp, Type t, boolean phy, boolean s, boolean con){
		name = n;
		basePower = bp;
		type = t;
		physical = phy;
		spread = s;
		contact = con;
	}

	//TODO this also seems naiive. Wow go past me.
	// Grass Moves
	public static final Attack
			ENERGYBALL = new Attack("Energy Ball", 90, Type.GRASS, false, false, false);

	// Rock Moves
	public static final Attack ROCKSLIDE = new Attack("Rock Slide", 75, Type.ROCK, true, true, false);

	//getters for Attacks

	public String getName(){
		return name;
	}

	public double getBasePower(){
		return basePower;
	}

	public Type getType(){
		return type;
	}
	
	public boolean getPhysical(){
		return physical;
	}
	
	public boolean getSpread(){
		return spread;
	}
	
	public boolean getContact(){
		return contact;
	}

}
