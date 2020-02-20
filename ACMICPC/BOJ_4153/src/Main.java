import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("");
        int[] a = new int[3];

        while (true) {
            for (int i = 0; i < 3; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);

            if (a[0] == 0 && a[1] == 0 && a[2] == 0) break;
            if ((a[2] * a[2]) == ((a[0] * a[0]) + (a[1] * a[1])))
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.println(sb.toString());
    }
}