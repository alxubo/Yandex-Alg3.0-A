import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A13 {

    public static int evaluater(String expression) {
        Deque<Character> onesAndZeros = new ArrayDeque<>();
        Deque<Character> functions = new ArrayDeque<>();
        boolean wasThereAnExlMark = false;

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            switch (token) {
                case '0', '1' -> {
                    onesAndZeros.addFirst(token);
                }
                case '!' -> {
                    i++;
                    wasThereAnExlMark = true;
                }
                case '(' -> {
                    StringBuilder sb = new StringBuilder();
                    int OBracketCOunter = 1;
                    int CBracketCOunter = 0;
                    i++;
                    while (OBracketCOunter != CBracketCOunter) {
                        if (expression.charAt(i) == '(') {
                            OBracketCOunter++;
                        } else if (expression.charAt(i) == ')') {
                            CBracketCOunter++;
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String expression = reader.readLine();




        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
