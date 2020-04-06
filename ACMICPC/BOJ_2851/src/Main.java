import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        for (int i = 0; i < 10; i++)
            a[i] = sc.nextInt();

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(answer + a[i] - 100) <= Math.abs(answer - 100)) {
                answer += a[i];
            }
            else
                break;
        }
        System.out.println(answer);
    }
}
