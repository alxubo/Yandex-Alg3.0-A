import java.util.Scanner;

public class A23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int layers = scanner.nextInt();
        if (layers == 1) {
            System.out.println(1);
            return;
        }

        int[] amountOfLayers = new int[layers + 1];
        amountOfLayers[1] = 1;
        amountOfLayers[2] = 5;
        for (int i = 3; i < amountOfLayers.length; i++) {
            if (i % 2 == 0) {
                amountOfLayers[i] = (3 * (amountOfLayers[i-1] - amountOfLayers[i-2])) + 3;
            } else {
                amountOfLayers[i] = (3 * (amountOfLayers[i-1] - amountOfLayers[i-2])) + 1;
            }
        }
        System.out.println(amountOfLayers[layers]);
    }
}
