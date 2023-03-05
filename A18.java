import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A18 {

    public static int[] toIntArr(String str) {
        int[] ret = new int[2];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ret[0] = Integer.parseInt(str.substring(0, i));
                ret[1] = Integer.parseInt(str.substring(i+1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            int[] kn = toIntArr(reader.readLine());
//
//            HashMap<Integer, Integer> whatIsWhere = new HashMap<>();
//            for (int i = 0; i < kn[1]; i++) {
//                for (Integer key: whatIsWhere.keySet()) {
//                    if (whatIsWhere.get(key) < )
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Exception during reading the input" + e.getMessage());
//        }
    }
}
