import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int joi = 0, ioi = 0;

        for (int i = 0; i + 3 <= s.length(); i++) {
            String tmp = s.substring(i, i + 3);

            if (tmp.equals("JOI")) {
                joi++;
                i++;
            }
            else if (tmp.equals("IOI")) {
                ioi++;
                i++;
            }
        }
        System.out.println(joi);
        System.out.println(ioi);
    }
}
