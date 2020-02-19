import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt() - a;
        int answer = v / (a - b) + 1;
        if (v % (a - b) > 0)
            answer++;

        System.out.println(answer);
    }
}