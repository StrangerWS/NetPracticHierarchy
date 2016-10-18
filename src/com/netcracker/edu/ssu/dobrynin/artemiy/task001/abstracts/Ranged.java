package com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;


/**
 * Created by User on 15.10.2016.
 */
public abstract class Ranged extends Weapon {
    protected double magazineCapacity;
    protected double magazineCount;
    protected Ammo ammo;
    protected String ammoType;

    void consumeAmmo(){
        if (magazineCount > 0)
            magazineCount--;
        else reload();
    }
    void reload(){
        magazineCount = magazineCapacity;
    }
    // Считаем, что патроны бесконечные
    // Для расширения функционала можно добавить класс игрока и вычитать патроны из его инвентаря

    protected void dealDamage(Entity target){
        consumeAmmo();
        lowerDurability();
        ammo.shoot(target);
        target.decreaseHP(damage);
    }
}
