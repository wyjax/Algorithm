import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int white = 1;
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            String str = sc.next();
            for (int j = 0; j < 8; j++) {
                if (white == 1 && str.charAt(j) == 'F')
                    answer++;
                white = 1 - white;
            }
            if (i % 2 == 1)
                white = 1;
            else
                white = 0;
        }
        System.out.println(answer);
    }
}
