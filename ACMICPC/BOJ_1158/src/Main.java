import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int k = 0;
        while (q.size() > 0) {
            k++;

            if (k == m) {
                list.add(q.poll());
                k = 0;
            }
            else
                q.add(q.poll());
        }

        System.out.print("<");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size() - 1) + ">");
    }
}