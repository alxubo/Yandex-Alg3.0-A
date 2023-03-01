import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A11 {

    private static float[] toFloatArr(String str) {
        String[] strsplit = str.split(" ");

        float[] ret = new float[strsplit.length];

        for (int i = 0; i < strsplit.length; i++) {
            ret[i] = Float.parseFloat(strsplit[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                float[] arrayToCheck = toFloatArr(reader.readLine());
                System.out.println(checkerIfSortPos(arrayToCheck));
            }


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }

    private static int checkerIfSortPos(float[] array) {
        float minValue = findMin(array);

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1] && array[i] != minValue) {
                return 0;
            } else if (array[i] == minValue) {
                minValue = findMin(Arrays.copyOfRange(array, i+1, array.length));
            }
        }
        return 1;
    }

    private static float findMin(float[] array) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1.0) {
                return 1;
            } else if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}

