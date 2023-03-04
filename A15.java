import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class A15 {

    public static int sbEqualsWithousSecChar(StringBuilder sb1, StringBuilder sb2) {
        if (sb1.charAt(0) != sb2.charAt(0)) {
            return 0;
        }
//        try {
            for (int i = 1; i < sb1.length(); i++) {
                if (sb1.charAt(i) != sb2.charAt(i+1)) {
                    return i+1; // the index in closing
                }
            }
            return -1;
//        } catch (IndexOutOfBoundsException e) {
//            return false;
//        }
    }

//    public static boolean checkIfXmlIsCorrect(String xml) {
//        try {
//
//            if (xml.length() == 0) {
//                return true;
//            }
//
//            boolean isOpenFlag;
//            Deque<StringBuilder> stack = new ArrayDeque<>();
//
//            for (int i = 0; i < xml.length(); i++) {
//                char token = xml.charAt(i);
//                if (token == '<') {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append('<');
//                    i++;
//                    if (xml.charAt(i) == '/') {
//                        isOpenFlag = false;
//                    } else {
//                        isOpenFlag = true;
//                    }
//                    while (xml.charAt(i) != '>') {
//                        sb.append(xml.charAt(i));
//                        i++;
//                    }
//                    sb.append('>');
//
//                    if (isOpenFlag) {
//                        stack.addFirst(sb);
//                    } else {
//                        if (stack.isEmpty()) {
//                            return false;
//                        }
//                        if (sbEqualsWithousSecChar(stack.getFirst(), sb)) {
//                            stack.removeFirst();
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
//            if (stack.isEmpty()) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public static int[] checkerForBracketProblem(String xml) {

        if (xml.charAt(0) != '<') {
            return new int[]{0, '<'};
        }

        if (xml.charAt(xml.length()-1) != '>') {
            return new int[]{xml.length()-1, '>'};
        }

        for (int i = 0; i < xml.length()-1; i++) {
            if (xml.charAt(i) == '>' && xml.charAt(i+1) != '<') {
                return new int[]{i+1, '<'};
            }
            if (xml.charAt(i+1) == '<' && xml.charAt(i) != '>') {
                return new int[]{i, '>'};
            }
        }
        return new int[] {-1};
    }
    public static String findAProblem(String xml) {
        int[] resultOFCheckingForBracket = checkerForBracketProblem(xml);
        if (resultOFCheckingForBracket.length != 1) {
            return xml.substring(0, resultOFCheckingForBracket[0]) +
                    (char) resultOFCheckingForBracket[1] +
                    xml.substring(resultOFCheckingForBracket[0] + 1);
        }

        boolean isOpenFlag;
        Deque<StringBuilder> stack = new ArrayDeque<>();

        for (int i = 0; i < xml.length(); i++) {
            char token = xml.charAt(i);
            if (token == '<') {
                StringBuilder sb = new StringBuilder();
                sb.append('<');
                i++;
                if (xml.charAt(i) == '/') {
                    isOpenFlag = false;
                } else {
                    isOpenFlag = true;
                }
                while (xml.charAt(i) != '>') {
                    sb.append(xml.charAt(i));
                    i++;
                }
                sb.append('>');

                if (isOpenFlag) {
                    stack.addFirst(sb);
                } else {

                    if (sb.length() == 3) {
                        // значит что проблемма тут и надо испарвить на значение внутри следующего
                    }

                    if (stack.isEmpty()) {
                        return "FUCK";
                    }
                    int indexInSb = sbEqualsWithousSecChar(stack.getFirst(), sb);
                    if (indexInSb == -1) {
                        stack.removeFirst();
                    } else {
                        return xml.substring(0, i - sb.length() + indexInSb + 1) +
                                (char) stack.getFirst().charAt(indexInSb-1) +
                                xml.substring(i-sb.length() + indexInSb + 2);
                    }
                }
            }
        }
        if (!(stack.isEmpty())) {
            int indexOfSbInStack = (stack.size())/2 + 1;
        } else {
            return xml;
        }

        return "HHHHHHHHHHHHHHH";
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String xml = reader.readLine();

            System.out.println(findAProblem(xml));

        } catch (IOException e) {
            System.out.println("Exception during reading the input" + e.getMessage());
        }
    }
}
