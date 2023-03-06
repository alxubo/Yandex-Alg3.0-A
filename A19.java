import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A19 {

    private static PriorityQueue<Long> intArr(int len) throws IOException {
        PriorityQueue<Long> result = new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            result.add((long) readInt());
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

    public static void main(String[] args) {
        try {
            int n = readInt();

            PriorityQueue<Long> toSum = intArr(n);

            long counter = 0;
            long sumOfTwoFirst;
            while (toSum.size() != 1) {
                sumOfTwoFirst = toSum.remove() + toSum.remove();
                counter = counter + sumOfTwoFirst;
                toSum.add(sumOfTwoFirst);
            }

            System.out.println(String.format("%.2f", counter * 0.05));


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
