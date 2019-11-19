import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            String []line = br.readLine().split(" ");

            if (line[0].equals("P")) {
                left.push(line[1].charAt(0));
            }
            else if (line[0].equals("L")) {
                if (left.size() > 0)
                    right.push(left.pop());
            }
            else if (line[0].equals("D")) {
                if (right.size() > 0)
                    left.push(right.pop());
            }
            else if (line[0].equals("B")) {
                if (left.size() > 0)
                    left.pop();
            }
        }

        while (left.size() > 0) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (right.size() > 0)
            sb.append(right.pop());

        System.out.println(sb.toString());
    }
}