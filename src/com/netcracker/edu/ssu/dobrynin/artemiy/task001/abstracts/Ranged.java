package com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;


/**
 * Created by User on 15.10.2016.
 */
public abstract class Ranged extends Weapon {
    double magazineCapacity;
    double magazineCount;

    void consumeAmmo(){
        if (magazineCount > 0)
            magazineCount--;
        else reload();
    }
    void reload(){
        magazineCount = magazineCapacity;
    }
    protected void dealDamage(Entity target){
        consumeAmmo();
        lowerDurability();
        target.decreaseHP(damage);
    }
}
