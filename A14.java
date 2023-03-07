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

            ArrayList<int[]> collWthItsLimits = new ArrayList<>();

            Deque<Integer> stackRight = new ArrayDeque<>();

            for (int i = 0; i < gistGram.length; i++) {
                while (!stackRight.isEmpty() && stackRight.getFirst() > gistGram[i]) {
                    collWthItsLimits.add(new int[]{stackRight.getFirst(), 0, i});
                    stackRight.removeFirst();
                }
                stackRight.addFirst(gistGram[i]);
            }
            while (!stackRight.isEmpty()) {
                collWthItsLimits.add(new int[]{stackRight.removeFirst(), 0, gistGram.length});
            }


            Deque<Integer> stackLeft = new ArrayDeque<>();
            int[] fromMap;
            for (int i = gistGram.length-1; i >= 0; i--) {
                while (!stackLeft.isEmpty() && stackLeft.getFirst() > gistGram[i]) {
                    fromMap = collWthItsLimits.get();
                    fromMap[0] = i;
                    collWthItsLimits.add(stackLeft.getFirst(), fromMap);
                    stackLeft.removeFirst();
                }
                stackLeft.addFirst(gistGram[i]);
            }
            while (!stackLeft.isEmpty()) {
                fromMap = collWthItsLimits.get(stackLeft.getFirst());
                fromMap[0] = -1;
                collWthItsLimits.put(stackLeft.getFirst(), fromMap);
                collWthItsLimits.put(stackLeft.removeFirst(), new int[]{0, gistGram.length});
            }
            int max = -1;
            int[] toCount;
            for (Integer i: collWthItsLimits.keySet()) {
                toCount = collWthItsLimits.get(i);
                if (max < (toCount[1] - 1 - toCount[0]) * i) {
                    max = (toCount[1] - 1 - toCount[0]) * i;
                }
            }

            System.out.println(max);


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
