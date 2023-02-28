import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A27 {
    public static int minOfT(int q, int w, int e) {
        int[] arr = new int[]{q,w,e};
        int j = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < j) {
                j = arr[i];
            }
        }
        return j;
    }

    public static int zeroIfEqual(char n, char m) {
        if (n == m) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            int[][] dp = new int[line1.length()+1][line2.length()+1];

            for (int i = 0; i < line1.length()+1; i++) {
                dp[i][0] = i;
            }

            for (int i = 0; i < line2.length()+1; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < line1.length()+1; i++) {
                for (int j = 1; j < line2.length()+1; j++) {
                    dp[i][j] = minOfT(dp[i][j-1] + 1, dp[i-1][j] + 1,
                            dp[i-1][j-1] + zeroIfEqual(line1.charAt(i-1), line2.charAt(j-1)));
                }
            }

            System.out.println(dp[line1.length()][line2.length()]);

        } catch (IOException e) {
            System.out.println("Exception during reading" + e.getMessage());
        }
    }
}
