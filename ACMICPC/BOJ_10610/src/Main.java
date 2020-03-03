import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 30의 배수는 각 자리의 수의 합이 30의 배수가 되어야 한다.
        // 0의 개수가 1개 이상이어야 하고 마지막자리에 0은 무조건 와야 한다.

        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int sum = 0;
        char[] c = sc.next().toCharArray();

        for (int i = 0; i < c.length; i++) {
            a[c[i] - '0']++;
            sum += c[i] - '0';
        }
        if (a[0] == 0 || sum % 3 > 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < a[i]; j++) {
                System.out.print(i);
            }
        }
    }
}