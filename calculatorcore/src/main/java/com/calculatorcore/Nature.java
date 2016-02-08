package com.calculatorcore;

//TODO probably not the worst implementation in the world, but should be reviewed
public class Nature {
	
	private String name;
	private int boost, drop;
	
	private Nature(String n, int b, int d){
		name = n;
		boost = b;
		drop = d;
	}
	private Nature(String n){
		name = n;
		boost = 7; //the 7s here should throw out of bounds indexes when checking for modifier
		drop = 7; //this should insure it always returns 1 for neutral natures
	}

	//keep natures in alphabetical order
	public static final Nature ADAMANT = new Nature("Adamant", 1, 3);
	public static final Nature BOLD = new Nature("Bold", 2, 1);
	public static final Nature BRAVE = new Nature("Brave", 1, 5);
	public static final Nature CAREFUL = new Nature("Careful", 4, 3);
	public static final Nature HARDY = new Nature("Hardy");
	public static final Nature IMPISH = new Nature("Impish", 2, 3);
	public static final Nature LONELY = new Nature("Lonely", 1, 2);
	public static final Nature MODEST = new Nature("Modest", 3, 1);
	public static final Nature QUIET = new Nature("Quiet", 3, 5);
	public static final Nature QUIRKY = new Nature("Quirky");
	public static final Nature RELAXED = new Nature("Relaxed", 2, 5);
	
	
	//I think a static array for storing natures is probably necessary, since they can be selected
	
	
	public double natModifier(int statIndex){
		if(statIndex == boost){
			return 1.1;
		}
		if(statIndex == drop){
			return 0.9;
		}
		else{
			return 1;
		}
	}
	
	public String getName(){
		return name;
	}
}
