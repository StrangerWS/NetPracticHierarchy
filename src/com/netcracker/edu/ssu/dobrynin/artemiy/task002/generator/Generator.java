package com.netcracker.edu.ssu.dobrynin.artemiy.task002.generator;

import java.util.Random;

/**
 * Created by User on 20.10.2016.
 */
public class Generator {
    public static int getRandomNumber(int origin, int bound){
        return (new Random().nextInt(bound - origin + 1) + origin);
    }
}
