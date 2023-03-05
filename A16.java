import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class A16 {

    public static int[] toIntArr(String str) {
        String[] strsplit = str.split(" ");

        int[] ret = new int[strsplit.length];

        for (int i = 0; i < strsplit.length; i++) {
            ret[i] = Integer.parseInt(strsplit[i]);
        }

        return ret;
    }

    public static int[] simpleMin(Integer[] array) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }
        return new int[]{min, minIndex}; // the first is the number, second is an index
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] nk = toIntArr(reader.readLine());
            int n = nk[0];
            int k = nk[1];

            int[] sequence = toIntArr(reader.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < k; i++) {
                deque.addLast(sequence[i]);
            }
            int[] helper = simpleMin(deque.toArray(new Integer[0]));
            int minInWinIndex = helper[1];
            int minInWindow = helper[0];
            System.out.println(minInWindow);
            int indexOfTheWindow = 1;
            int toCompare;

            for (int i = k; i < n; i++) {
                deque.removeFirst();
                toCompare = sequence[i];
                if (indexOfTheWindow > minInWinIndex) {
                    deque.addLast(toCompare);
                    if (toCompare <= minInWindow) {
                        System.out.println(toCompare);
                        minInWinIndex = i;
                        minInWindow = toCompare;
                    } else {
                        helper = simpleMin(deque.toArray(new Integer[0]));
                        minInWinIndex = helper[1] + indexOfTheWindow;
                        minInWindow = helper[0];
                        System.out.println(minInWindow);
                    }
                } else {
                    deque.addLast(toCompare);
                    if (toCompare < minInWindow) {
                        System.out.println(toCompare);
                        minInWinIndex = i;
                        minInWindow = toCompare;
                    } else {
                        System.out.println(minInWindow);
                    }
                }
                indexOfTheWindow++;
            }

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
