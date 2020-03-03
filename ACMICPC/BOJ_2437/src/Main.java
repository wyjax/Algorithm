import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            // (sum(1 ~ i-1) + 1)보다 i번쨰 수가 클 경우 sum + 1은 만들 수 없다.
            if (sum + 1 < a[i]) break;
            sum += a[i];
        }
        System.out.println(sum + 1);
    }
}

/*
3 1 6 2 7 30 1
sort()
1 3 5 17
  1 4 9 16   << 누적합 SUM(i - 1) + 1 < a[i] 라면 sum+1의 수는 만들 수 없다.

>> 2는 만들 수 없다
 */