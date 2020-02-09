import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1])
                    return -1;
                else if (o1[1] == o2[1]) {
                    if (o1[0] < o2[0])
                        return -1;
                    else if (o1[0] > o2[0])
                        return 1;
                    else
                        return 0;
                }
                else
                    return 1;
            }
        });

        int cnt = 0;
        int e = -1;
        for (int[] arr : a) {
            if (e <= arr[0]) {
                e = arr[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}