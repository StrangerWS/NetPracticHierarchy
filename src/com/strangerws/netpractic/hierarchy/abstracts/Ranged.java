package com.strangerws.netpractic.hierarchy.abstracts;

/**
 * Created by User on 15.10.2016.
 */
public abstract class Ranged extends Weapon {
    double magazineCapacity;
    double reloadTime;

    abstract void consumeAmmo();
    abstract void reload();
}
