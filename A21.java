import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class A21 {

    public static void step(int[] arr, int index, int[] cubes, int desiredIndex, int recLimit, int recLayer) {
        if (recLayer == recLimit) {
            return;
        }
        if (index >= arr.length) {
            return;
        }
        for (int i = 1; i < cubes.length; i++) {
            if (index + cubes[i] < arr.length) {
                if (arr[index + cubes[i]] == 0) {
                    arr[index + cubes[i]] = arr[index] + 1;
                } else {
                    arr[index + cubes[i]] = Math.min(arr[index] + 1, arr[index + cubes[i]]);
                }
                if (index + cubes[i] == desiredIndex) {
                    return;
                }

                step(arr, index + i, cubes, desiredIndex, recLimit, recLayer+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1000000) {
            System.out.println(1);
            return;
        }
        int[] array = new int[n+1];

        array[0] = 0;

        int[] cubes = new int[100];
        for (int i = 0; i < 100; i++) {
            cubes[i] = i * i * i;
        }

        for (int i = 1; i < 101; i++) {
            step(array, 0, cubes, n, i, 0);
            if (array[n] != 0) {
                System.out.println(array[n]);
                return;
            }
        }


    }
}
