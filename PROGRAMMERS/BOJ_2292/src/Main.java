import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int answer = 1;
        long count = 1;

        while (count < n) {
            count = count + (answer * 6);
            answer++;
        }

        System.out.println(answer);
    }
}
