import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++)
                a[i][j] = sc.nextInt();
        }

        int answer = 0;

        for (int i = 123; i <= 999; i++) {
            String s = Integer.toString(i);
            if (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) continue;
            if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') continue;

            boolean check = true;

            for (int j = 0; j < n; j++) {
                String s2 = Integer.toString(a[j][0]);
                int strike = 0, ball = 0;

                for (int k = 0; k < 3; k++) {
                    for (int t = 0; t < 3; t++) {
                        if (k == t && s.charAt(k) == s2.charAt(t)) {
                            strike++;
                            break;
                        }
                        else if (s.charAt(k) == s2.charAt(t)) {
                            ball++;
                            break;
                        }
                    }
                }

                if (strike != a[j][1] || ball != a[j][2]) {
                    check = false;
                    break;
                }
            }
            if (check)
                answer++;
        }

        System.out.println(answer);
    }
}
