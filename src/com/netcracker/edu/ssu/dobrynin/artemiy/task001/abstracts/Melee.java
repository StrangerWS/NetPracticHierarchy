package com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.interfaces.Bloody;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.interfaces.Fiery;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.interfaces.Icy;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.interfaces.Stunning;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;

/**
 * Created by User on 15.10.2016.
 */
public abstract class Melee extends Weapon implements Bloody, Fiery, Icy, Stunning {
    protected double strengthRequirements;

    protected void dealDamage(Entity target){
        target.decreaseHP(damage);
        lowerDurability();
    }
}