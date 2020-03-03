import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int ans = 0;

        if (n == 1)
            ans = 1;
        /*
        * 세로 1일 때 : 위, 아래로 이동이 불가하기 때문에 갈 수 있는 곳이 없음
        * */
        else if (n == 2) {
            ans = Math.min((m + 1) / 2, 4);
            /*
            * 세로가 2라면 2,3을 사용하여 최대 3번 갈 수 있다
            * */
        }
        else if (n >= 3) {
            if (m <= 6) {
                // 가로가 6 이하라면 3회만 사용해야 하기 때문에 3 + 1이 최대이다
                ans = Math.min(4, m);
            }
            else {
                // m이 7 이상이면 2, 3방법은 1번씩만 사용하면 되고 그 외에는 오른쪽으로 1칸씩만 이동하니깐 m - 2
                ans = m - 2;
            }
        }

        System.out.println(ans);
    }
}