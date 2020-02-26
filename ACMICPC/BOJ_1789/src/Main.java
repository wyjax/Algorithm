import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        int idx = 1;
        while (s > 0) {
            s -= idx;
            idx++;
        }
        idx --;
        if (s < 0)
            idx--;
        System.out.println(idx);
    }
}
