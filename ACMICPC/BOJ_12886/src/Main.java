import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        boolean[][] check = new boolean[1501][1501];

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextInt();
            sum += input[i];
        }
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(input);
        Queue<Integer> q = new LinkedList<>();
        q.add(input[0]);
        q.add(input[1]);
        /**
         * 3개의 그룹의 합은 일정하기 때문에 오름차순에서 2번째 까지의 돌만 검사하면 나머지 하나는 똑같다.
         */

        while (q.size() > 0) {
            int[] v = new int[3];
            for (int i = 0; i < 2; i++)
                v[i] = q.remove();
            v[2] = sum - (v[0] + v[1]);

            if (v[0] == v[1] && v[1] == v[2]) {
                System.out.println(1);
                return;
            }
            Arrays.sort(v);

            if (v[0] != v[1]) {
                int a = v[0] + v[0];
                int b = v[1] - v[0];
                if (!check[a][b]) {
                    check[a][b] = true;
                    q.add(a);
                    q.add(b);
                }
            }
            if (v[0] != v[2]) {
                int a = v[0] + v[0];
                int b = v[2] - v[0];
                if (!check[a][b]) {
                    check[a][b] = true;
                    q.add(a);
                    q.add(b);
                }
            }
            if (v[1] != v[2]) {
                int a = v[1] + v[1];
                int b = v[2] - v[1];
                if (!check[a][b]) {
                    check[a][b] = true;
                    q.add(a);
                    q.add(b);
                }
            }
        }

        if (check[sum / 3][sum / 3]) // 3등분으로 나누는게 가능하면 1
            System.out.println(1);
        else
            System.out.println(0);
    }
}

// AB AC BC