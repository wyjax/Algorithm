import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] op = {'D', 'S', 'L', 'R'};

        while (n-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            boolean[] check = new boolean[10001];
            int[] from = new int[10001];
            char[] c = new char[10001];

            Queue<Integer> q = new LinkedList<>();
            check[A] = true;
            from[A] = -1;
            q.add(A);

            while (q.size() > 0) {
                int now = q.remove(), next = 0;

                for (int i = 0; i < 4; i++) {

                    if (i == 0)
                        next = (now * 2) % 10000;
                    else if (i == 1)
                        next = now - 1;
                    else if (i == 2)
                        next = (now % 1000) * 10 + now / 1000;
                    else if (i == 3)
                        next = (now / 10) + (now % 10) * 1000;

                    if (next == -1)
                        next = 9999;
                    if (!check[next]) {
                        q.add(next);
                        check[next] = true;
                        from[next] = now;
                        c[next] = op[i];
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (A != B) {
                sb.append(c[B]);
                B = from[B];
            }
            System.out.println(sb.reverse());
        }
    }
}

/**
 * 처음 방식 > 시간 초과
 */
/*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder[] op;

        while (n-- > 0) {
            int num = sc.nextInt();
            int obj = sc.nextInt();
            op = new StringBuilder[10000];

            for (int i = 0; i < 10000; i++) {
                op[i] = new StringBuilder();
            }

            String tmp_s = Integer.toString(num);
            for (int l = 0; l < (4 - Integer.toString(num).length()); l++)
                tmp_s = "0" + tmp_s;

            Queue<String> q = new LinkedList<>();
            q.add(tmp_s);

            while (q.size() > 0) {
                String s = q.remove();
                int now = Integer.parseInt(s);

                for (int i = 0; i < 4; i++) {
                    StringBuilder tmp = new StringBuilder();
                    int next = 0;

                    if (i == 0) { // D
                        next = (now * 2) % 10000;
                        if (op[next].length() == 0) {
                            op[next].append(op[now].toString() + "D");
                            tmp.append(Integer.toString(next));
                            for (int k = 0; k < (4 - Integer.toString(next).length()); k++)
                                tmp.insert(0, "0");
                            q.add(tmp.toString());
                        }
                    }
                    else if (i == 1) { // S
                        next = now - 1;
                        if (next <= 0)
                            next = 9999;
                        if (op[next].length() == 0) {
                            op[next].append(op[now].toString() + "S");
                            tmp.append(Integer.toString(next));
                            for (int k = 0; k < (4 - Integer.toString(next).length()); k++)
                                tmp.insert(0, "0");
                            q.add(tmp.toString());
                        }
                    }
                    else if (i == 2) { // L
                        Deque<String> d = new ArrayDeque<>();
                        for (int k = 1; k < 4; k++)
                            d.addLast(s.substring(k, k + 1));
                        d.addLast(s.substring(0, 1));
                        for (String iter : d)
                            tmp.append(iter);
                        next = Integer.parseInt(tmp.toString());
                        if (op[next].length() == 0) {
                            op[next].append(op[now].toString() + "L");
                            q.add(tmp.toString());
                        }
                    }
                    else if (i == 3) { // R
                        Deque<String> d = new ArrayDeque<>();
                        for (int k = 0; k < 3; k++)
                            d.addLast(s.substring(k, k + 1));
                        d.addFirst(s.substring(3, 4));
                        for (String iter : d)
                            tmp.append(iter);
                        next = Integer.parseInt(tmp.toString());
                        if (op[next].length() == 0) {
                            op[next].append(op[now].toString() + "R");
                            q.add(tmp.toString());
                        }
                    }
                    if (op[obj].length() > 0)
                        break;
                }
                if (op[obj].length() > 0)
                    break;
            }
            System.out.println(op[obj].toString());
        }
 */