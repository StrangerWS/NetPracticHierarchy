package com.netcracker.edu.ssu.dobrynin.artemiy.task003.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 04.11.2016.
 */
public class ExpressionHandler {

    public int handle(int first, int second, char operator) {
        switch (operator) {
            case ('*'):
                return first * second;
            case ('/'):
                return first / second;
            case ('%'):
                return first % second;
            case ('+'):
                return first + second;
            case ('-'):
                return first - second;
            default:
                return 0;
        }
    }

    public boolean isNumber(String expression) {
        Pattern pattern = Pattern.compile("[+-]?[\\d]+");
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    public boolean isLowPriorityOperator(char ch) {
        return ch == '+' || ch == '-';
    }

    public boolean isHighPriorityOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '%';
    }
}
