package com.example.examples.services;

import org.springframework.stereotype.Service;

enum CalculatorState {
    INIT,
    FIRST_FIGURE,
    SECOND_FIGURE,
    RESULT,
    ERROR
}

@Service
public class CalculatorService {

    private CalculatorState currentState = CalculatorState.INIT;
    private int firstFigure = 0;
    private int secondFigure = 0;
    private String operator = "";
    private double result = 0;

      public void processOperation(String opetation) {
        for (int i = 0; i < opetation.length(); i++) {
            if (Character.isDigit(opetation.charAt(i))) {
                int digit = Character.getNumericValue(opetation.charAt(i));
                this.handleNumber(digit);
            } else {
                this.handleSymbol(opetation.charAt(i));
            }
        }
    }
    
        void handleNumber(int number) {
        switch (currentState) {
            case INIT:
                firstFigure = number;
                currentState = CalculatorState.FIRST_FIGURE;
                break;
            case FIRST_FIGURE:
                firstFigure = firstFigure * 10 + number;
                break;
            case SECOND_FIGURE:
                secondFigure = secondFigure * 10 + number;
                break;
            case RESULT:
                break;
            case ERROR:
                break;
            default:
                break;
        }
    }

    void handleSymbol(char symbol) {
        switch (currentState) {
            case INIT:
                currentState = CalculatorState.ERROR;
                break;
            case FIRST_FIGURE:
                if (this.isOperator(symbol)) {
                    operator = Character.toString(symbol);
                    currentState = CalculatorState.SECOND_FIGURE;
                    break;
                } else {
                    currentState = CalculatorState.ERROR;
                    break;
                }
            case SECOND_FIGURE:
            if(symbol == '='){
                this.calculateResult();
                currentState = CalculatorState.RESULT;
                break;
            }else{
                currentState = CalculatorState.ERROR;
                break;
            }
            case RESULT:
                // currentState = CalculatorState.INIT;
                break;
            case ERROR:
                break;
            default:
                break;
        }
    }

    boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == 'd';
    }

    void calculateResult() {
        switch (operator) {
            case "+":
                result = firstFigure + secondFigure;
                break;
            case "-":
                result = firstFigure - secondFigure;
                break;
            case "*":
                result = firstFigure * secondFigure;
                break;
            case "d":
                result = (double) firstFigure / secondFigure;
                break;
            default:
                break;
        }
    }

    public void initStateMachine() {
        currentState = CalculatorState.INIT;
        firstFigure = 0;
        secondFigure = 0;
        operator = "";
        result = 0;
    }

    public boolean isValidExpression() {
        return currentState == CalculatorState.RESULT;
    }

    public int getFirstFigure() {
        return firstFigure;
    }

    public int getSecondFigure() {
        return secondFigure;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

}
