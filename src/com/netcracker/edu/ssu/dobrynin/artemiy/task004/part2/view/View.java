package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.view;

import java.util.TreeSet;

/**
 * Created by DobryninAM on 21.11.2016.
 */
public class View {

    public static void printTreeSet(TreeSet set) {
        for (Object o : set) {
            System.out.println(o);
            System.out.println();
        }
        System.out.println();
    }
}
