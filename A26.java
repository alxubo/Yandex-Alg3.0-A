import java.math.BigInteger;
import java.util.Scanner;

public class A26 {
    public static BigInteger counterRec(BigInteger[][] array, int n, int m, int positionN, int positionM) {
        if (positionM >= m || positionN >= n || positionN < 0 || positionM < 0) {
            return new BigInteger("0");
        }
        if (positionM == 0 && positionN == 0) {
            array[0][0] = new BigInteger("1");
            return array[0][0];
        }

        if (array[positionN][positionM] == null) {
            array[positionN][positionM] = ((counterRec(array, n, m, positionN - 2, positionM + 1)
                    .add(counterRec(array, n, m, positionN - 2, positionM - 1))).add(
                    counterRec(array, n, m, positionN - 1, positionM - 2))).add(
                    counterRec(array, n, m, positionN + 1, positionM - 2));
        }
        return array[positionN][positionM];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger[][] array = new BigInteger[n][m];

        System.out.println(counterRec(array, n , m,n-1, m - 1));

    }
}
