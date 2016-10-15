package com.strangerws.netpractic.hierarchy.abstracts;

/**
 * Created by User on 15.10.2016.
 */
public abstract class Weapon {
    private double damage;
    private double weight;
    private double price;
    private double durability;

    abstract double dealDamage();
    abstract void lowerDurability();
    abstract void breakWeapon();
}
