package com.netcracker.edu.ssu.dobrynin.artemiy.task001.ranged.ammo;

import com.netcracker.edu.ssu.dobrynin.artemiy.task001.abstracts.Ammo;

import java.util.Random;

/**
 * Created by User on 18.10.2016.
 */
public class Bullet extends Ammo {
    Bullet() {
        damage = 5;

        Random random = new Random();
        int getRand = random.nextInt(100);
        if (getRand < 20 && getRand >= 0) {
            modifier = "Icy";
        }
        if (getRand < 40 && getRand >= 20) {
            modifier = "Bloody";
        }
        if (getRand < 60 && getRand >= 40) {
            modifier = "Fiery";
        }
        if (getRand < 80 && getRand >= 60) {
            modifier = "Stunning";
        }
    }
}