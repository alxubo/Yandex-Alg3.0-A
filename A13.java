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
            case '^' -> {return 0;}
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

    public static int evaluater(String expression) {
        if (expression.length() == 1) {
            return Character.valueOf(expression.charAt(0));
        }
        int bracketFlag = 0;
        if (expression.length() == 2) {
            if (expression.charAt(1) == '0') {
                return 1;
            } else {
                return 0;
            }
        }
        if (expression.charAt(0) == '(' && expression.charAt(expression.length()-1) == ')') {
            bracketFlag = 1;
        }
        int indexOfLeastWeightedFun = 0;
        char leastWfunction = ' ';
        int leastFunctionWeight = Integer.MAX_VALUE;
        for (int i = expression.length()-bracketFlag-1; i >= 0; i--) {
            if (isFunction(expression.charAt(i)) && functionWeight(expression.charAt(i)) <= leastFunctionWeight) {
                indexOfLeastWeightedFun = i;
                leastWfunction = expression.charAt(i);
                leastFunctionWeight = functionWeight(expression.charAt(i));
            }
        }
        final boolean rightExpressionEvaluated = intToBool(evaluater(expression.substring(indexOfLeastWeightedFun + 1, expression.length() - bracketFlag)));
        final boolean leftExpressionEvaluated= intToBool(evaluater(expression.substring(bracketFlag, indexOfLeastWeightedFun)));

        switch (leastWfunction) {
            case '!' -> {
                if (evaluater(expression.substring(1)) == 1) {
                    return 0;
                } else {
                    return 1;
                }
            }
            case '&' -> {
                return  boolToInt(leftExpressionEvaluated && rightExpressionEvaluated);
            }
            case '|' -> {
                return  boolToInt(leftExpressionEvaluated | rightExpressionEvaluated);
            }
            case '^' -> {
                return  boolToInt(leftExpressionEvaluated ^ rightExpressionEvaluated);
            }
        }
        return -99999999;

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
