package com.netcracker.edu.ssu.dobrynin.artemiy.task001.ranged.base;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts.Ranged;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.misc.Entity;
import com.netcracker.edu.ssu.dobrynin.artemiy.task001.ranged.ammo.Bullet;

/**
 * Created by User on 17.10.2016.
 */
public class Pistol extends Ranged {
    Pistol(){
        damage = 20;
        durability = 800;
        magazineCapacity = 17;
        ammoType = "Arrow";
    }

    public void shoot(Entity target, Bullet bullet){
        ammo = bullet;
        dealDamage(target);
    }
}
