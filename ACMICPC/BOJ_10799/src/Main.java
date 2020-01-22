import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int cnt = 0;
        char pre = ' ';
        int sum = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
                pre = c;
            }
            else if (c == ')') {
                cnt--;
                if (pre == ')')
                    sum++;
                else
                    sum += cnt;
                pre = c;
            }
        }

        System.out.println(sum);
    }
}