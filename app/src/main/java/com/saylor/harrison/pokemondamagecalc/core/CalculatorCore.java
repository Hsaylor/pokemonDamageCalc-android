package com.saylor.harrison.pokemondamagecalc.core;

/**
 * Created by harrisonsaylor on 10/20/16.
 */

public class CalculatorCore {

  int finalDamage[];

  public CalculatorCore(){
    finalDamage = new int[16];
  }

  public void calcDamage(Pokemon attacker, Pokemon defender, Attack a, boolean crit, boolean doubles){
    double tempDam;
    double damage[] = new double[16];
    double modifier;

    //I need a way to enter level
    tempDam = Math.floor(Math.floor((Math.floor((2 * attacker.getLevel()) / 5 + 2) * a.getBasePower() * calcAtkStat(attacker, a)) / calcDefStat(defender, a)) / 50 + 2);
    modifier = calcModifier(a, crit, doubles, attacker);
    for(int i=0; i<16; i++){
      damage[i] = Math.floor(tempDam * (85 + i) / 100); //the damage variation factor. Between 0.85 and 1
      damage[i] = pokeRound(damage[i] * checkSTAB(attacker, a));
      damage[i] = Math.floor(damage[i] * a.getType().calcDualTypeWeakness(defender.getType1(), defender.getType2()));
      damage[i] = Math.max(1, damage[i]);
      damage[i] = pokeRound(damage[i] * modifier);

      finalDamage[i] = (int)damage[i];

    }
  }

  public double calcModifier(Attack a, boolean crit, boolean doubles, Pokemon attacker){
    double tempMod = 1;

    tempMod = tempMod * isCrit(crit, attacker);
    tempMod = tempMod * isSpread(a, doubles);

    return tempMod;
  }

  //Calcing final stats
  //calcStat factors in Nature
  private double calcAtkStat(Pokemon p, Attack a){
    if(a.getPhysical() == true){
      return calcStat(p, 1);
    }
    else
      return calcStat(p, 3);
  }

  private double calcDefStat(Pokemon p, Attack a){
    if(a.getPhysical() == true){
      return calcStat(p, 2);
    }
    else
      return calcStat(p, 4);
  }

  //make a different method for calcing hp
  //along the lines of this Math.floor((base * 2 + ivs + Math.floor(evs / 4)) * level / 100) + level + 10;

  //THIS DOES NOT CALC HP PROPERLY
  private double calcStat(Pokemon p, int i){
    return Math.floor((Math.floor((p.getBaseSpDef() * 2 + p.getIVs(i) + Math.floor(p.getEVs(i) / 4)) * (p.getLevel()/50)) + 5) * p.getNature().natModifier(i));
  }

  //check STAB method (should Attacks have this?)
  private double checkSTAB(Pokemon p, Attack a){
    if(p.getType()[0] == a.getType() || p.getType()[1] == a.getType()){
      return 1.5;
    }
    else if(p.getActiveAbility() == Ability.PROTEAN){
      return 1.5;
    }
    else
      return 1;
  }

  //isCrit does not currently ignore any stat drops
  private double isCrit(boolean c, Pokemon attacker){
    if(c == true){
      if(attacker.getActiveAbility() == Ability.SNIPER){
        return 2.25;
      }
      else{
        return 1.5;
      }
    }
    else
      return 1;
  }

  private double isSpread(Attack a, boolean d){
    if(a.getSpread() == true && d == true){
      return 0.75;
    }
    else
      return 1;
  }

  //jacked from showdown to make sure rounding works right
  public double pokeRound(double num) {
    return (num % 1 > 0.5) ? Math.ceil(num) : Math.floor(num);
  }

  /*public static void main(String args[]){
    CalculatorCore c = new CalculatorCore();

    Pokemon.venusaur.setNature(Nature.MODEST);
    c.calcDamage(Pokemon.venusaur, Pokemon.tar, Attack.ENERGYBALL, false, true);

    for(int i = 0; i<16; i++){
      System.out.println(c.finalDamage[i]);
    }
  }*/
}
