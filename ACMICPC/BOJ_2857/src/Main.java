import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char[] s = sc.next().toCharArray();

            for (int j = 0; j < s.length - 2; j++) {
                if (s[j] == 'F' && s[j + 1] == 'B' && s[j + 2] == 'I') {
                    sb.append((i + 1) + " ");
                    break;
                }
            }
        }
        if (sb.length() == 0)
            System.out.println("HE GOT AWAY!");
        else
            System.out.println(sb.toString());
    }
}
