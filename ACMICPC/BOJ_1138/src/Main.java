import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람수 입력
        int[] a = new int[n]; // 줄을 기억하는 배열

        for (int i = 0; i < n; i++) {
            int taller = sc.nextInt(); // 항상 입력받는 시점에서는 현재 입력된 것 중에서 자신이 가장 크다

            for (int j = 0; j < n; j++) {
                if (taller == 0 && a[j] == 0) { // 지나칠 만큼 지나쳤고 자리가 있다면
                    a[j] = i + 1; // 그 자리에 앉는다.
                    break;
                }
                else if (a[j] == 0) { // 보고있는 자리가 아무도 없고 나보다 큰 사람 수만큼 안지나쳤으면
                    taller--; // 지나쳐야하는 사람 수를 줄여준다.
                }

                // 자기보다 작은 사람이 있다면 대가없이 지나친다.
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

0