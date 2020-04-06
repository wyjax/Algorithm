import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int val = (w * w) + (h * h);

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int tmp = a * a;
            if (val < tmp)
                bw.write("NE\n");
            else
                bw.write("DA\n");
        }
        bw.flush();
    }
}
