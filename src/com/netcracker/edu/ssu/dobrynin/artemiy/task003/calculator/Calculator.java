package com.netcracker.edu.ssu.dobrynin.artemiy.task003.calculator;

import com.netcracker.edu.ssu.dobrynin.artemiy.task003.handler.ExpressionHandler;
import com.netcracker.edu.ssu.dobrynin.artemiy.task003.handler.StringHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 04.11.2016.
 */
public class Calculator {
    private StringHandler stringHandler = new StringHandler();
    private ExpressionHandler expressionHandler = new ExpressionHandler();

    public int calculate(String line) {
        List<String> expressions = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        int firstNumber;
        int secondNumber;
        int result = 0;

        stringHandler.handle(line, expressions, operators);


        if (expressions.size() == 1 && expressionHandler.isNumber(expressions.get(0))) {
            return Integer.parseInt(expressions.get(0));
        } else if (expressions.size() == 1 && !expressionHandler.isNumber(expressions.get(0))) {
            return calculate(expressions.get(0).substring(1, expressions.get(0).length() - 1));
        }

        boolean isFirstSteep = true;

        for (int i = 0; i < operators.size(); i++) {
            if (expressionHandler.isHighPriorityOperator(operators.get(i)) && isFirstSteep
                    || expressionHandler.isLowPriorityOperator(operators.get(i)) && !isFirstSteep) {

                if (expressionHandler.isNumber(expressions.get(i))) {
                    firstNumber = Integer.parseInt(expressions.get(i));
                } else {
                    firstNumber = calculate(expressions.get(i).substring(1, expressions.get(0).length() - 1));
                }
                expressions.remove(i);

                if (expressionHandler.isNumber(expressions.get(i))) {
                    secondNumber = Integer.parseInt(expressions.get(i));
                } else {
                    secondNumber = calculate(expressions.get(i).substring(1, expressions.get(i).length() - 1));
                }
                expressions.remove(i);

                result = expressionHandler.handle(firstNumber, secondNumber, operators.get(i));
                operators.remove(i);

                if (expressions.isEmpty()) {
                    break;
                } else {
                    expressions.add(i, "" + result);
                }

                if (!operators.isEmpty()) {
                    i--;
                }
            }
            if (!operators.isEmpty() && i + 1 == operators.size() && isFirstSteep) {
                isFirstSteep = false;
                i = -1;
            }
        }

        return result;
    }
}
