import java.util.Scanner;

public class A4at2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int pr = scanner.nextInt();
        int pc = scanner.nextInt();

        int pi = 2 * (pr - 1) + pc;
        int vi1 = pi - k;
        int vi2 = pi + k;

        if (vi1 > 0 || vi2 <= n) {
            if (vi1 > 0 && vi2 <= n) {
                int vc1;
                if (vi1 % 2 == 1) {
                    vc1 = 1;
                } else {
                    vc1 = 2;
                    vi1--;
                }
                vi1--;
                int vr1 = vi1 / 2 + 1;
                int vc2;
                if (vi2 % 2 == 1) {
                    vc2 = 1;
                } else {
                    vc2 = 2;
                    vi2--;
                }

                vi2--;
                int vr2 = vi2 / 2 + 1;
                if (vr2 - pr <= pr - vr1) {
                    System.out.println(vr2 + " " + vc2);
                } else {
                    System.out.println(vr1 + " " + vc1);
                }
            } else if (vi1 > 0) {
                int vc1;
                if (vi1 % 2 == 1) {
                    vc1 = 1;
                } else {
                    vc1 = 2;
                    vi1--;
                }
                vi1--;
                int vr1 = vi1 / 2 + 1;
                System.out.println(vr1 + " " + vc1);
            } else {
                int vc2;
                if (vi2 % 2 == 1) {
                    vc2 = 1;
                } else {
                    vc2 = 2;
                    vi2--;
                }
                vi2--;
                int vr2 = vi2 / 2 + 1;
                System.out.println(vr2 + " " + vc2);

            }
        } else {
            System.out.println(-1);
        }
    }
}
