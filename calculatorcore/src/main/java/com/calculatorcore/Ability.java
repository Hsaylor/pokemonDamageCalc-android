package com.calculatorcore;

public class Ability {
	
	private String name;
	private double multiplier;
	
	private Ability(String n){
		name = n;
	}

	//TODO this is naiive. What was I thinking when I started this? Do this a better way
	public static final Ability PARENTALBOND = new Ability("ParentalBond");
	public static final Ability PROTEAN = new Ability("Protean");
	public static final Ability OVERGROW = new Ability("Overgrow");
	public static final Ability SANDSTREAM = new Ability("Sandstream");
	public static final Ability SNIPER = new Ability("Sniper");
	public static final Ability TOUGHCLAWS = new Ability("ToughClaws");
	
	public double findMultiplier(Ability a){
		return 1;
	}
	


}
