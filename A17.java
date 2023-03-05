import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A17 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());

            ArrayList<String> list = new ArrayList<>();
            String line;
            System.out.println();
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                switch (line.charAt(0)) {
                    case '+' -> {
                        list.add(line.substring(2));
                    }
                    case '*' -> {
                        if (list.size() % 2 == 0) {
                            list.add(list.size()/2, line.substring(2));
                        } else {
                            list.add(list.size()/2 + 1, line.substring(2));
                        }

                    }
                    case '-' -> {
                        System.out.println(list.get(0));
                        list.remove(0);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
