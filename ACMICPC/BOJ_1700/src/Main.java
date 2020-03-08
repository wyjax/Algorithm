import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] d = new int[n];
        int ans = 0;

        for (int i = 0; i < k; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < k; i++) {
            boolean use = false;

            // 빈 곳이 있거나 이미 꽂아져 있는 경우
            for (int j = 0; j < n; j++) {
                if (d[j] == 0) {
                    d[j] = a[i];
                    use = true;
                    break;
                }
                else if (d[j] == a[i]) {
                    use = true;
                    break;
                }
            }
            // 빈 곳이 없어서 하나를 빼야하는 경우
            if (!use) {
                int lastidx = -1;
                int idx = -1;
                // 꽂아져 있는 것 중에 앞으로 등장하지 않거나 제일 늦게 나오는 것부터 뽑는다.
                for (int j = 0; j < n; j++) {
                    int cnt = 0;
                    for (int q = i + 1; q < k; q++) {
                        if (d[j] == a[q])
                            break;
                        cnt++;
                    }
                    if (cnt > idx) {
                        lastidx = j;
                        idx = cnt;
                    }
                }
                d[lastidx] = a[i];
                ans++;
            }
        }
        System.out.println(ans);
    }
}