import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A14 {

    private static int[] intArr(int len) throws IOException {
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = readInt();
        }
        return result;
    }

    private static int readInt() throws IOException {
        int ret = 0;
        boolean dig = false;
        for (int c = 0; (c = System.in.read()) != -1; ) {
            if (c >= '0' && c <= '9') {
                dig = true;
                ret = ret * 10 + c - '0';
            } else if (dig) break;
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            int n = readInt();

            int[] gistGram = intArr(n);

            int[][] collWithIndexes = new int[gistGram.length][3];
            // index -> [height, leftLim, rightLim]

            Deque<int[]> stackForRight = new ArrayDeque<>();


            int[] indexAndHeightForRight;
            for (int i = 0; i < gistGram.length; i++) {
                while (!stackForRight.isEmpty() && stackForRight.getFirst()[1] > gistGram[i]) {
                    indexAndHeightForRight = stackForRight.removeFirst();
                    collWithIndexes[indexAndHeightForRight[0]] = new int[]{indexAndHeightForRight[1], 0, i}; // i - index of lower
                }
                stackForRight.addFirst(new int[]{i, gistGram[i]});
            }

            while (!stackForRight.isEmpty()) {
                indexAndHeightForRight = stackForRight.removeFirst();
                collWithIndexes[indexAndHeightForRight[0]] = new int[]{indexAndHeightForRight[1], 0, gistGram.length}; // i - index of lower
            }

            Deque<int[]> stackForLeft = new ArrayDeque<>();

            int[] indexAndHeightForLeft;
            for (int i = gistGram.length-1; i >= 0; i--) {
                while (!stackForLeft.isEmpty() && stackForLeft.getFirst()[1] > gistGram[i]) {
                    indexAndHeightForLeft = stackForLeft.removeFirst();
                    collWithIndexes[indexAndHeightForLeft[0]][1] = i+1; // i - index of lower
                }
                stackForLeft.addFirst(new int[]{i, gistGram[i]});
            }

            while (!stackForRight.isEmpty()) {
                indexAndHeightForRight = stackForRight.removeFirst();
                collWithIndexes[indexAndHeightForRight[0]][1] = 1; // i - index of lower
            }

            long max = -1;

            for (int[] arr: collWithIndexes) {
                if (max <  ((long) arr[2] -  (long) arr[1]) * (long) arr[0]) {
                    max = ((long)arr[2] - (long)arr[1]) * (long)arr[0];
                }
            }
            System.out.println(max);

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
