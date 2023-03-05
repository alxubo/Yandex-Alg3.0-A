import java.io.*;
import java.util.*;

public class A16 {

    public static int[] toIntArr(String str) {
        String[] strsplit = str.split(" ");

        int[] ret = new int[strsplit.length];

        for (int i = 0; i < strsplit.length; i++) {
            ret[i] = Integer.parseInt(strsplit[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int[] nk = toIntArr(reader.readLine());
                int n = nk[0];
                int k = nk[1];

                int[] sequence = toIntArr(reader.readLine());

                TreeSet<Integer> set = new TreeSet<>();
                Map<Integer, Integer> map = new HashMap<>();

                for (int i = 0; i < k; i++) {
                    set.add(sequence[i]);
                    if (map.containsKey(sequence[i])) {
                        map.put(sequence[i], map.get(sequence[i]) + 1);
                    } else {
                        map.put(sequence[i], 1);
                    }
                }

                System.out.println(set.first());
                for (int i = k; i < n; i++) {
                    int toRemove = sequence[i - k];
                    if (map.get(toRemove) == 1) {
                        map.remove(toRemove);
                        set.remove(toRemove);
                    } else {
                        map.put(toRemove, map.get(toRemove) - 1);
                    }
                    set.add(sequence[i]);
                    if (map.containsKey(sequence[i])) {
                        map.put(sequence[i], map.get(sequence[i]) + 1);
                    } else {
                        map.put(sequence[i], 1);
                    }
                    System.out.println(set.first());

                }

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
