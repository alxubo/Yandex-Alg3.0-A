import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A12 {

    public static boolean checkExpressionOnBeingParsable(String expession) {
        boolean functionFlag = false;
        boolean digitFlag = false;

        for (int i = 0; i < expession.length(); i++) {
            char token = expession.charAt(i);
             switch (token) {
                 case ' ' ->  {
                     continue;
                 }
                 case '+', '-', '*' -> {
                     if (functionFlag) {
                         throw new IllegalArgumentException("Wrong");
                     }
                     functionFlag = true;
                     digitFlag = false;
                 }
                 case '1','2','3','4','5','6','7',
                         '8','9','0' -> {
                     i++;
                     while (i < expession.length() && Character.isDigit(expession.charAt(i))) {
                         i++;
                     }
                     i--;
                     if (digitFlag) {
                         throw new IllegalArgumentException("Wrong");
                     }
                     functionFlag = false;
                     digitFlag = true;
                 }
                 case '(', ')' -> {
                     functionFlag = true;
                     digitFlag = false;
                 }
                 default -> throw new IllegalArgumentException("WRONG");
             }
        }
        return true;
    }


    public static int functionWeight(char ch) {
        switch (ch) {
            case '*' -> {return 2;}
            case '+', '-' -> {return 1;}
            default -> {
                throw new IllegalArgumentException("functionWeight function collapsed <- for dev");
            }
        }
    }



    public static boolean isFunction(char ch) {
        switch (ch) {
            case '+', '*', '-'-> {return true;}
            default -> {
                return false;
            }
        }
    }


    public static boolean allowedCharacters(char ch) {
        switch (ch) {
            case '+', '|', '^', '&', '(', ')',
                    '1','2','3','4','5','6','7',
                                    '8','9','0' -> {return true;}
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

    public static int ifJustADidgit(String expression) {
        int leftWhSpIndex = 0;
        int rightWpIndex = expression.length();
        for (int i = 0 ; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                leftWhSpIndex++;
            } else {
                break;
            }
        }

        for (int i = expression.length()-1; i >= 0; i--) {
            if (expression.charAt(i) == ' ') {
                rightWpIndex--;
            } else {
                break;
            }
        }

        expression = expression.substring(leftWhSpIndex, rightWpIndex);
        String[] splited = expression.split(" ");
        if (splited.length == 1) {
            return Integer.parseInt(splited[0]);
        } else {
            throw new NumberFormatException("exc");
        }
    }

    public static int evaluaterWithNoBrackets(String expression) {
        try {
            int dig = ifJustADidgit(expression);

            return dig;
        } catch (NumberFormatException e) {
            int indexOfLeastWeightedFun = 0;
            char leastWFunction = 's';
            int leastFunctionWeight = Integer.MAX_VALUE;

            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) != ' ') {
                    if (isFunction(expression.charAt(i)) && functionWeight(expression.charAt(i)) <= leastFunctionWeight) {
                        indexOfLeastWeightedFun = i;
                        leastWFunction = expression.charAt(i);
                        leastFunctionWeight = functionWeight(expression.charAt(i));
                    }
                }
            }
            final int rightExpressionEvaluated = evaluaterWithNoBrackets(expression.substring(indexOfLeastWeightedFun + 1));
            final int leftExpressionEvaluated = evaluaterWithNoBrackets(expression.substring(0, indexOfLeastWeightedFun));

            switch (leastWFunction) {
                case '+' -> {
                    return leftExpressionEvaluated + rightExpressionEvaluated;
                }
                case '-' -> {
                    return leftExpressionEvaluated - rightExpressionEvaluated;
                }
                case '*' -> {
                    return leftExpressionEvaluated * rightExpressionEvaluated;
                }
                default -> throw new RuntimeException("Something went wrong evaluterwithnobrackets <- for dev");
            }
        }
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

    public static int mainFunc(String expression) {
        if (checkExpressionOnBeingParsable(expression)) {
            return evaluater(expression);
        }
        return -99999999;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String expression = reader.readLine();
            try {
//                String str = "1 2";
//                System.out.println(Arrays.toString(str.split(" ")));
                System.out.println(mainFunc(expression));
//                System.out.println(evaluater(expression));
            } catch (IllegalArgumentException e) {
                System.out.println("WRONG");
            }

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
