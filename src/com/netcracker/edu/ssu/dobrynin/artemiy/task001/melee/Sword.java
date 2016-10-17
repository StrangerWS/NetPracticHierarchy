package com.netcracker.edu.ssu.dobrynin.artemiy.task001.melee;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts.Melee;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;

import java.util.Random;

/**
 * Created by User on 17.10.2016.
 */
public class Sword extends Melee {
    Sword(){

        damage = 100;
        durability = 500;
        strengthRequirements = 2;

        Random random = new Random();
        int getRand = random.nextInt(100);
        if (getRand < 20 && getRand >= 0){
            modifiers.add("Icy");
        }
        if (getRand < 40 && getRand >= 20){
            modifiers.add("Bloody");
        }
        if (getRand < 60 && getRand >= 40){
            modifiers.add("Fiery");
        }
        if (getRand < 80 && getRand >= 60){
            modifiers.add("Stunning");
        }
    }

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

    public void hit(Entity target){
        dealDamage(target);
        if (modifiers.contains("Icy")){
            setFreeze(target);
        }
        if (modifiers.contains("Bloody")){
            setBloodLoss(target);
        }
        if (modifiers.contains("Fiery")){
            setFire(target);
        }
        if (modifiers.contains("Stunning")){
            setStun(target);
        }
    }
}
