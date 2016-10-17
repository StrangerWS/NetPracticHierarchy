package com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.interfaces.*;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;

/**
 * Created by User on 17.10.2016.
 */
public class Ammo implements Bloody, Fiery, Icy, Stunning, Explosive {
    private String modifier = "";
    private double damage;

    @Override
    public void setFire(Entity target) {
        target.isOnFire();
    }

    @Override
    public void setBloodLoss(Entity target) {
        target.isLosingBlood();
    }

    @Override
    public void setFreeze(Entity target) {
        target.isFrozen();
    }

    @Override
    public void setStun(Entity target) {
        target.isStunned();
    }

    @Override
    public void explode(Entity target) {
        target.explosionDamage();
    }
    public void shoot(Entity target, Ranged base){
        base.dealDamage(target);
        if (modifier.equals("Icy")){
            setFreeze(target);
        }
        if (modifier.equals("Bloody")){
            setBloodLoss(target);
        }
        if (modifier.equals("Fiery")){
            setFire(target);
        }
        if (modifier.equals("Stunning")){
            setStun(target);
        }
    }


}
