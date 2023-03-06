import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TransferQueue;

public class A18 {

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

    public static int[] findMinAndIndex(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return new int[]{min, index};
    }

    public static void main(String[] args) {
        try {
            int k = readInt();
            int n = readInt();

            int[][] times = new int[n][2];
            for (int i = 0; i < n; i++) {
                times[i] = intArr(2);
            }


            int index = 2;
            TreeMap<Integer, ArrayList<Integer>> mapa = new TreeMap<>();
            mapa.put(times[0][1], new ArrayList<>(List.of(1)));

            for (int i = 1; i < n; i++) {
                int currentTimeArr = times[i][0];
                int currentTimeDep = times[i][1];

                int indexWithinArray = -1;
                Integer timeOfLeavingForTheFirst = -1;
                int minDepo;
                ArrayList<Integer> openDepos = new ArrayList<>();

                for (Integer key: mapa.keySet()) {
                    if (key > currentTimeArr) {
                        if (openDepos.size() != 0) {
                            for (Integer key1: mapa.keySet()) {
                                if (mapa.get(key1).contains(Collections.min(openDepos))) {

                                }
                            }
                        }
                    } else {
                        openDepos.addAll(mapa.get(key));
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
