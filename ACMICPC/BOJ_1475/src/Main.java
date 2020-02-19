import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = new int[9];
        Arrays.fill(a , 0);
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '9')
                c = '6';
            if (a[c - '0'] == 0) {
                answer++;
                for (int j = 0; j < 9; j++) {
                    a[j]++;
                }
                a['6' - '0']++;
            }
            a[c - '0']--;
        }

        System.out.println(answer);
    }
}