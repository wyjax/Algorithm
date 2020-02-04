import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        search(a, 0);
        System.out.println(ans);
    }

    static void search(ArrayList<Integer> a, int sum) {
        if (ans < sum)
            ans = sum;
        if (a.size() <= 2)
            return;

        for (int i = 1; i < a.size() - 1; i++) {
            int val = a.get(i - 1) * a.get(i + 1);
            int tmp = a.get(i);
            a.remove(i);
            search(a, sum + val);
            a.add(i, tmp);
        }
    }
}