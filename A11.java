import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class A11 {

    private static double[] toDoubleArr(String str) {
        String[] strsplit = str.split(" ");

        double[] ret = new double[strsplit.length];

        for (int i = 1; i < strsplit.length; i++) {
            ret[i] = Double.parseDouble(strsplit[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                double[] arrayToCheck = toDoubleArr(reader.readLine());
                if (checker(arrayToCheck)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }

    private static boolean checker(double[] arrayToCheck) {
        Deque<Double> stack = new ArrayDeque<>();
        double[] sortedArray = new double[arrayToCheck.length];
        System.arraycopy(arrayToCheck, 0, sortedArray, 0, arrayToCheck.length);
        Arrays.sort(sortedArray);

        int theNextRequaired = 0;
        for (int i = 0; i < arrayToCheck.length; i++) {
            if (arrayToCheck[i] == sortedArray[theNextRequaired]) {
              theNextRequaired++;
              while (!stack.isEmpty() && stack.getFirst() == sortedArray[theNextRequaired]) {
                  stack.removeFirst();
                  theNextRequaired++;
              }
            } else {
                stack.addFirst(arrayToCheck[i]);
            }
        }
        if (stack.isEmpty() && theNextRequaired == arrayToCheck.length) {
            return true;
        } else {
            return false;
        }
    }


}

