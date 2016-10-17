package com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;

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

