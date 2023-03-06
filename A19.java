import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A19 {

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

    public static void main(String[] args) {
        try {
            int n = readInt();
            int[] toSum = intArr(n);
            long sum = 0;
            if (n % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    sum = sum + toSum[i];
                }
                
            }


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
