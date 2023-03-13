import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class A31 {
    public static void rec(int x, int y, char[][] matrix, boolean[][] tfmatrix) {
        if (matrix[x][y] == '*' || tfmatrix[x][y]) {
            return;
        }
        tfmatrix[x][y] = true;
        rec(x-1, y, matrix,tfmatrix);
        rec(x + 1, y, matrix,tfmatrix);
        rec(x, y-1, matrix,tfmatrix);
        rec(x, y+1, matrix,tfmatrix);

    }
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            String[][] helperM = new String[n][n];

            for (int i = 0; i < n; i++) {
                helperM[i] = reader.readLine().split("");
            }
            char[][] matix = new char[n][n];

            for (int i = 0; i< n; i++) {
                for (int j = 0; j < n; j++) {
                    matix[i][j] = helperM[i][j].charAt(0);
                }
            }


            String[] helper = reader.readLine().split(" ");
            int x = Integer.parseInt(helper[0]) -1;
            int y = Integer.parseInt(helper[1]) -1;

            boolean[][] tfmatrix = new boolean[n][n];


            rec(x, y, matix, tfmatrix);

            int counter = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tfmatrix[i][j]) {
                        counter++;
                    }
                }
            }
            System.out.println(counter);

        } catch (IOException e) {
            System.out.println("exception during reading");
        }
    }
}
