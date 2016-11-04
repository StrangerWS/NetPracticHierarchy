package com.netcracker.edu.ssu.dobrynin.artemiy.task003.handler;

import java.util.List;

/**
 * Created by User on 04.11.2016.
 */
public class StringHandler {

    private ExpressionHandler expressionHandler = new ExpressionHandler();

    public void handle(String input, List<String> expressions, List<Character> operators) {
        int length = 0;
        int count = 0;

        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            length++;
            count++;
            if (length < input.length() && input.charAt(length) == '(') {
                input = '(' + (input.charAt(0) + input.substring(length + 1, input.length() - 1));
                length++;
                if (input.charAt(length - 1) == '-' && input.charAt(length) == '-') {
                    input = input.substring(length + 1, input.length());
                    expressions.add(input);
                    return;
                }
            }
        }

        while (length < input.length()) {
            if (input.charAt(length) == '(') {
                int bracketCount = 1;
                length++;
                count++;
                while (bracketCount > 0) {
                    if (input.charAt(length) == '(') {
                        bracketCount++;
                    } else if (input.charAt(length) == ')') {
                        bracketCount--;
                    }
                    length++;
                    count++;
                }
                expressions.add(input.substring(length - count, length));
                count = 0;
                if (length < input.length()) {
                    operators.add(input.substring(length, length + 1).charAt(0));
                }
            } else {
                while (length < input.length() && !expressionHandler.isLowPriorityOperator(input.charAt(length))
                        && !expressionHandler.isHighPriorityOperator(input.charAt(length))) {
                    length++;
                    count++;
                }
                expressions.add(input.substring(length - count, length));
                count = 0;
                if (length < input.length()) {
                    operators.add(input.substring(length, length + 1).charAt(0));
                }
            }
            length++;
        }
    }
}
