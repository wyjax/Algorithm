import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[8][2];

        for (int i = 0; i < 8; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = i + 1;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 3; i < 8; i++) {
            sum += a[i][0];
            list.add(a[i][1]);
        }
        System.out.println(sum);
        Collections.sort(list);
        for (int num : list)
            System.out.print(num + " ");
        System.out.println();
    }
}
