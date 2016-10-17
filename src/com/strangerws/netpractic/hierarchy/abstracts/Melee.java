package com.strangerws.netpractic.hierarchy.abstracts;

import com.strangerws.netpractic.hierarchy.interfaces.Bloody;
import com.strangerws.netpractic.hierarchy.interfaces.Fiery;
import com.strangerws.netpractic.hierarchy.interfaces.Icy;
import com.strangerws.netpractic.hierarchy.interfaces.Stunning;
import com.strangerws.netpractic.hierarchy.misc.Entity;

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