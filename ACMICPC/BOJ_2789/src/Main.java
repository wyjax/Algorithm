import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "CAMBRIDGE";
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            boolean check = true;

            for (int j = 0; j < a.length(); j++) {
                if (s.charAt(i) == a.charAt(j)) {
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.print(s.charAt(i));
        }
    }
}
