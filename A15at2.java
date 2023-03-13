import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A15at2 {
//    public static int checkIfProblemWithBrackets(String str) {
//        for (int i = 1; i < str.length(); i++) {
//            <a><ab></ab><c></c></a>
//            if
//        }
//    }
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String xml = reader.readLine();
        } catch (IOException e) {
            System.out.println("Exception during reading xml" + e.getMessage());
        }


    }
}
