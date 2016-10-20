package com.netcracker.edu.ssu.dobrynin.artemiy.task002.helper;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.generator.Generator;
import javafx.util.Pair;

/**
 * Created by User on 20.10.2016.
 */
public class Helper {
    public Helper(){ }

    public String rangeHelper(int origin, int bound){
        return "Загадано число от " + origin + " до " + bound;
    }
    public Pair<Integer, Integer> cutRange(int origin, int bound, int number){
        int middle = (bound - origin)/2 + origin;
        if (number < middle){
            return new Pair<>(origin, middle);
        }
        else return new Pair<>(middle, bound);
}
    public String locateInt(int mention, int guessNumber){
        if (mention > guessNumber){
            return ("Загаданное число меньше " + mention);
        } else if (mention < guessNumber){
            return ("Загаданное число больше " + mention);
        } else return "Это оно! Оно!";
    }
    public int randInt(int guessNumber){
        return Generator.getRandomNumber((guessNumber - 10), (guessNumber + 10));
    }
}
