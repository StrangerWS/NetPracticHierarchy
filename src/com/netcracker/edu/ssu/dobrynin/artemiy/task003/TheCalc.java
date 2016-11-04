package com.netcracker.edu.ssu.dobrynin.artemiy.task003;

import com.netcracker.edu.ssu.dobrynin.artemiy.task003.calculator.Calculator;

import java.util.Scanner;

/**
 * Created by User on 28.10.2016.
 */
public class TheCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(scanner.nextLine()));
    }
}
