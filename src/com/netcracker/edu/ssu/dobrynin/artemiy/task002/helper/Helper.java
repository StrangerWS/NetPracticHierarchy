package com.netcracker.edu.ssu.dobrynin.artemiy.task002.helper;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.generator.Generator;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.lang.ru_RU.Messages;
import javafx.util.Pair;

/**
 * Created by User on 20.10.2016.
 */
public class Helper {
    public Helper(){ }

    public String rangeHelper(int origin, int bound){
        return String.format(Messages.HELPER_BOUNDS, origin, bound);
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
            return String.format(Messages.HELPER_LOCATE_MSG, "меньше", mention);
        } else if (mention < guessNumber){
            return String.format(Messages.HELPER_LOCATE_MSG, "больше", mention);
        } else return String.format(Messages.HELPER_LOCATE_MSG, "равно", mention);
    }
    public int randInt(int guessNumber){
        return Generator.getRandomNumber((guessNumber - 10), (guessNumber + 10));
    }
}
