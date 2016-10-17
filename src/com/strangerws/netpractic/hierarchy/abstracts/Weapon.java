package com.strangerws.netpractic.hierarchy.abstracts;

import com.strangerws.netpractic.hierarchy.misc.Entity;

import java.util.TreeSet;

/**
 * Created by User on 15.10.2016.
 */
public abstract class Weapon {
    protected double damage;
    protected double durability;
    protected TreeSet<String> modifiers;

    abstract void dealDamage(Entity target);

    void lowerDurability() {
        if (durability > 0) {
            durability--;
        } else breakWeapon();
    }

    void breakWeapon() {
        damage = 0;
    }
}

