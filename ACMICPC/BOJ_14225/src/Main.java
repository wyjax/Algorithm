import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a;
    static int[] ans = new int[2000000];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        search(0, 0);
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    static void search(int sum, int idx) {
        if (sum > 0) {
            ans[sum]++;
        }

        for (int i = idx; i < n; i++) {
            search(sum + a[i], i + 1);
        }
    }
}