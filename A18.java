import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
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

    public static void main(String[] args) {
        try {
            int k = readInt();
            int n = readInt();
            int[][] times = new int[n][2];
            for (int i = 0; i < n; i++) {
                times[i] = intArr(2);
            }

            int index = 2;
            TreeMap<Integer, Integer> mapa = new TreeMap<>();
            if (n == 1) {
                mapa.put(times[0][1], 1);
                System.out.println(1);
                return;
            }
            mapa.put(times[0][1], 1);
            int depo = 0;
            for (int i = 1; i < n; i++) {
                Integer lastkey = null;
                for (Integer key: mapa.keySet()) {
                    if (key >= times[i][0]) {
                        if (lastkey != null) {
                            depo = mapa.get(lastkey);
                            System.out.println(depo);
                            mapa.remove(lastkey);
                            mapa.put(times[i][1], depo);
                            break;
                        } else {
                            if (index > k) {
                                System.out.print("0 ");
                                System.out.print(i+1);
                                return;
                            }
                            mapa.put(times[i][1], index);
                            index++;
                            break;
                        }
                    }
                    lastkey = key;
                }
            }


        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
