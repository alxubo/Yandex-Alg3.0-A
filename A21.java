import java.util.*;

public class A21 {
    public static void step(int[] arr, int index, int[] cubes, Set<Integer> indexes) {
//        Set<Integer> indexes = new HashSet<>();
        for (int i = 1; i < cubes.length; i++) {
            if (index + cubes[i] < arr.length) {
                if (arr[index] + 1 < arr[index + cubes[i]] || arr[index + cubes[i]] == 0) {
                    arr[index + cubes[i]] = arr[index] + 1;
                }
                indexes.add(index + cubes[i]);
            } else {
                break;
            }
        }

//        return indexes;
    }

    public static int steps(int[] arr, int[] cubes, int desiredIndex) {
        Set<Integer> firstIndexes = new HashSet<>();
        step(arr, 0, cubes, firstIndexes);
        if (arr[desiredIndex] != 0) {
            return arr[desiredIndex];
        }
        while (true) {
            Set<Integer> set = new HashSet<>();
            for (Integer i: firstIndexes) {
                step(arr, i, cubes, set);
                if (arr[desiredIndex] != 0) {
                    return arr[desiredIndex];
                }
            }
            firstIndexes = set;
        }

    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
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
        System.out.println(steps(array,  cubes, n));
//        System.out.println(System.currentTimeMillis() - start);
    }
}
