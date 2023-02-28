import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A13 {

    public static boolean intToBool(int x) {
        if (x == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int boolToInt(boolean x) {
        if (x) {
            return 1;
        } else {
            return 0;
        }
    }



    public static int functionWeight(char ch) {
        switch (ch) {
            case '!' -> {return 3;}
            case '&' -> {return 2;}
            case '|' -> {return 1;}
            case '^' -> {return 1;}
            default -> {
                throw new IllegalArgumentException("functionWeight function collapsed <- for dev");
            }
        }
    }

    public static boolean isFunction(char ch) {
        switch (ch) {
            case '!', '|', '^', '&' -> {return true;}
            default -> {
                return false;
            }
        }
    }

    public static boolean areThereOBrackets(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                return true;
            }
        }
        return false;
    }

    public static int evaluaterWithNoBrackets(String expression) {
        if (expression.length() == 1) {
            return Character.getNumericValue(expression.charAt(0));
        }
        int indexOfLeastWeightedFun = 0;
        char leastWFunction = ' ';
        int leastFunctionWeight = Integer.MAX_VALUE;
        for (int i = 0; i < expression.length(); i++) {
            if (isFunction(expression.charAt(i)) && functionWeight(expression.charAt(i)) <= leastFunctionWeight) {
                indexOfLeastWeightedFun = i;
                leastWFunction = expression.charAt(i);
                leastFunctionWeight = functionWeight(expression.charAt(i));
            }
        }
        final boolean rightExpressionEvaluated = intToBool(evaluaterWithNoBrackets(expression.substring(indexOfLeastWeightedFun + 1)));


        switch (leastWFunction) {
            case '!' -> {
                if (evaluaterWithNoBrackets(expression.substring(1)) == 1) {
                    return 0;
                } else {
                    return 1;
                }
            }
            case '&' -> {
                final boolean leftExpressionEvaluated = intToBool(evaluaterWithNoBrackets(expression.substring(0, indexOfLeastWeightedFun)));
                return boolToInt(leftExpressionEvaluated && rightExpressionEvaluated);
            }
            case '|' -> {
                final boolean leftExpressionEvaluated = intToBool(evaluaterWithNoBrackets(expression.substring(0, indexOfLeastWeightedFun)));
                return boolToInt(leftExpressionEvaluated | rightExpressionEvaluated);
            }
            case '^' -> {
                final boolean leftExpressionEvaluated = intToBool(evaluaterWithNoBrackets(expression.substring(0, indexOfLeastWeightedFun)));
                return boolToInt(leftExpressionEvaluated ^ rightExpressionEvaluated);
            }
        }
        return -99999;
    }

    public static int evaluater(String expression) {
        if (expression.length() == 1) {
            return Character.getNumericValue(expression.charAt(0));
        }
        if (areThereOBrackets(expression)) {
            StringBuilder expressionWithoutBrackets = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    StringBuilder sb = new StringBuilder();
                    int ObracketCounter = 1;
                    int CbracketCounter = 0;
                    i++;
                    while (ObracketCounter != CbracketCounter) {
                        if (expression.charAt(i) == '(') {
                            ObracketCounter++;
                        } else if (expression.charAt(i) == ')') {
                            CbracketCounter++;
                        }
                        sb.append(expression.charAt(i));
                        i++;
                    }
                    sb.deleteCharAt(sb.length()-1);
                    i--;
                    expressionWithoutBrackets.append(evaluater(sb.toString()));
                } else {
                    expressionWithoutBrackets.append(expression.charAt(i));
                }
            }
            return evaluaterWithNoBrackets(expressionWithoutBrackets.toString());
        } else {
            return evaluaterWithNoBrackets(expression);
        }

    }


    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String expression = reader.readLine();
            System.out.println(evaluater(expression));
        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
