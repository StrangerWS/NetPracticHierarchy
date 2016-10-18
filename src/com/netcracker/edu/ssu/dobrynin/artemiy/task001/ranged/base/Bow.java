package com.netcracker.edu.ssu.dobrynin.artemiy.task001.ranged.base;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts.Ranged;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.ranged.ammo.Arrow;

/**
 * Created by User on 17.10.2016.
 */
public class Bow extends Ranged{
    Bow(){
        damage = 100;
        durability = 500;
        magazineCapacity = 1;
        ammoType = "Arrow";
    }

    public void shoot(Entity target, Arrow arrow){
        ammo = arrow;
        dealDamage(target);
    }
}
