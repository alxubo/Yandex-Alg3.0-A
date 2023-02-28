import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class A22 {

    public static int[] toIntArr(String str) {
        // maybe slow well see
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

            String line0 = reader.readLine();
            String line = reader.readLine();

            int[] narr = toIntArr(line0);
            int n = narr[0];

            int[] a = toIntArr(line);

            int[] dp = new int[n];
            int[] previousPosition = new int[n];

            // стандартный алгоритм с ниирка проблема в том что работает за квадрат возможно надо будет переписать
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                previousPosition[i] = -1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        previousPosition[i] = j;
                    }
                }
            }

            int positionOfLast = 0;
            int ret0 = dp[0];
            for (int i = 0; i < n; i++) {
                if (dp[i] > ret0) {
                    positionOfLast = i;
                    ret0 = dp[i];
                }
            }

            ArrayList<Integer> ret = new ArrayList<>();

            while (positionOfLast != -1) {
                ret.add(a[positionOfLast]);
                positionOfLast = previousPosition[positionOfLast];
            }
//            System.out.println(ret0);


            for (int i = ret.size()-1; i >=0; i--) {
                System.out.print(ret.get(i));
                System.out.print(" ");
            }
        } catch (IOException e) {}

    }
}
