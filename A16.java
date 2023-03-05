import java.io.*;
import java.util.*;

public class A16 {
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
        boolean ifMinus = false;
        for (int c = 0; (c = System.in.read()) != -1; ) {
            if (c == '-') {
                ifMinus = true;
            }
            if (c >= '0' && c <= '9') {
                dig = true;
                ret = ret * 10 + c - '0';
            } else if (dig) break;
        }
        if (ifMinus) {
            return -ret;
        } else {
            return ret;
        }
    }

//    public static int[] toIntArr(String line, int len) {
//        StringTokenizer st = new StringTokenizer(line, " ");
//        int[] result = new int[len];
//        int index = 0;
//        while (st.hasMoreTokens()) {
//           result[index] = Integer.parseInt(st.nextToken());
//           index++;
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//                int[] nk = toIntArr(reader.readLine(), 2);
//                int n = nk[0];
//                int k = nk[1];
//
//                int[] sequence = toIntArr(reader.readLine(), n);


                int n = readInt();
                int k = readInt();
                int[] sequence = intArr(n);

                Deque<Integer> stack = new ArrayDeque<>(n);
                stack.addFirst(sequence[0]);
                for (int i = 1; i < k; i++) {
                    while (!stack.isEmpty()) {
                        if (stack.getFirst() > sequence[i]) {
                            stack.removeFirst();
                        } else {
                            break;
                        }
                    }
                    stack.addFirst(sequence[i]);
                }
                System.out.println(stack.getLast());
                int toDelete;
                for (int i = k; i < n; i++) {
                    toDelete = sequence[i-k];
                    if (toDelete == stack.getLast()) {
                        stack.removeLast();
                    }
                    while (!stack.isEmpty()) {
                        if (stack.getFirst() > sequence[i]) {
                            stack.removeFirst();
                        } else {
                            break;
                        }
                    }
                    stack.addFirst(sequence[i]);
                    System.out.println(stack.getLast());

                }
                System.out.println();
//            System.out.println(System.currentTimeMillis() - start);

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
