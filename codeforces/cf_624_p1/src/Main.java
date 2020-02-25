import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int num = a - b;

            if (num == 0)
                System.out.println(0);
            else if (num > 0) {
                if (num % 2 == 0)
                    System.out.println(1);
                else
                    System.out.println(2);
            }
            else {
                if (num % 2 == 0)
                    System.out.println(2);
                else
                    System.out.println(1);
            }
        }
    }
}