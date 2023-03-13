import java.util.Scanner;

public class A23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int layers = scanner.nextInt();
        switch (layers) {
            case 1 -> {
                System.out.println(1);
                return;
            }
            case 2 -> {
                System.out.println(5);
                return;
            }
            case 3 -> {
                System.out.println(13);
                return;
            }
            default -> {
                long[] amountOfLayers = new long[layers + 1];
                amountOfLayers[1] = 1;
                amountOfLayers[2] = 5;
                amountOfLayers[3] = 13;
                for (int i = 3; i < amountOfLayers.length; i++) {
                    if (i % 2 != 0) {
                        amountOfLayers[i] = (3 * (amountOfLayers[i-1] - amountOfLayers[i-2])) + 1;
                    } else {
                        amountOfLayers[i] = (3 * (amountOfLayers[i-1] - amountOfLayers[i-2])) +
                                amountOfLayers[i-3] + 2;
                    }
                }
                System.out.println(amountOfLayers[layers]);
            }
        }


    }
}
