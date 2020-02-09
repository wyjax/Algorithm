import java.util.HashSet;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class Main {
    static final long limit = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long t = sc.nextLong();

        Queue<Long> q = new LinkedList<>();
        Queue<StringBuilder> qs = new LinkedList<>();
        HashSet<Long> check = new HashSet<>();

        q.add(s);
        qs.add(new StringBuilder());
        check.add(s);

        while (q.size() > 0) {
            long x = q.remove();
            StringBuilder sb = new StringBuilder(qs.remove());

            if (x == t) {
                if (sb.length() == 0)
                    System.out.println(0);
                else
                    System.out.println(sb);
                return;
            }

            if (0 <= x * x && x * x <= limit && !check.contains(x * x)) {
                q.add(x * x);
                qs.add(new StringBuilder(sb).append("*"));
                check.add(x * x);
            }
            if (0 <= x + x && x + x <= limit && !check.contains(x + x)) {
                q.add(x + x);
                qs.add(new StringBuilder(sb).append("+"));
                check.add(x + x);
            }
            if (0 <= x - x && x - x <= limit && !check.contains(x - x)) {
                q.add(x - x);
                qs.add(new StringBuilder(sb).append("-"));
                check.add(x - x);
            }
            if (x != 0 && 0 <= x / x && x / x <= limit && !check.contains(x / x)) {
                q.add(x / x);
                qs.add(new StringBuilder(sb).append("/"));
                check.add(x / x);
            }
        }
        System.out.println(-1);
    }
}