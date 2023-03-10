import java.util.Scanner;

public class A26 {
    public static int counterRec(int n, int m, int positionN, int positionM) {
        if (positionM >= m || positionN >= n || positionN < 0 || positionM < 0) {
            return 0;
        }
        if (positionM == 0 && positionN == 0) {
            return 1;
        }
        return counterRec(n, m, positionN - 2, positionM + 1) +
                counterRec(n, m, positionN - 2, positionM - 1) +
                counterRec(n, m, positionN - 1, positionM - 2) +
                counterRec(n, m, positionN + 1, positionM - 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(counterRec(n , m,n-1, m - 1));

    }
}
