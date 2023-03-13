import java.util.Scanner;

class A21at2 {
    public static int steps(int n, int[] cubes, int[] array) {
        int cube = 1;
        int indexOfTheCube = 1;
        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.MAX_VALUE;
            while (cube <= i) {
                if (cube == i) {
                    array[i] = 1;
                } else if (array[i] > array[i - cube]) {
                    array[i] = array[i - cube] + 1;
                }
                indexOfTheCube++;
                cube = cubes[indexOfTheCube];
            }
            indexOfTheCube = 1;
            cube = 1;
        }
        return array[n];
    }

    public static void main(String[] args) {
//        long time = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1000000) {
            System.out.println(1);
            return;
        }

        int[] array = new int[n + 1];

        int[] cubes = new int[]{0, 1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197,
                2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261, 10648, 12167, 13824, 15625, 17576, 19683,
                21952, 24389, 27000, 29791, 32768, 35937, 39304, 42875, 46656, 50653, 54872, 59319, 64000,
                68921, 74088, 79507, 85184, 91125, 97336, 103823, 110592, 117649, 125000, 132651, 140608, 148877,
                157464, 166375, 175616, 185193, 195112, 205379, 216000, 226981, 238328, 250047, 262144, 274625, 287496,
                300763, 314432, 328509, 343000, 357911, 373248, 389017, 405224, 421875, 438976, 456533, 474552, 493039, 512000,
                531441, 551368, 571787, 592704, 614125, 636056, 658503, 681472, 704969, 729000, 753571, 778688, 804357, 830584,
                857375, 884736, 912673, 941192, 970299, 1000000};

        System.out.println(steps(n, cubes, array));
//        System.out.println(System.currentTimeMillis() - time);
    }
}
 