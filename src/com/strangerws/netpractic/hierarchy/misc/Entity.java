package com.strangerws.netpractic.hierarchy.misc;

/**
 * Created by User on 17.10.2016.
 */
public class Entity {
    protected double hp;

    Entity(double hp){
        this.hp = hp;
    }

    public void decreaseHP(double damage){
        this.hp -= damage;
    }
    public void isOnFire(){}
    public void isStunned(){}
    public void isFrozen(){}
    public void isLosingBlood(){}
    public void explosionDamage() {}
}
