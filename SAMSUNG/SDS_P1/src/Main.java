import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[][][] a = new int[6][3][3];
    static int[][][] tmp = new int[6][3][3];
    static int cnt = 1;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    a[i][j][k] = idx++;
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] s = br.readLine().split(" ");
            deppCopy(tmp, a);
            for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                rotation(Integer.parseInt(s[i + 1]));
            }
            print(Integer.parseInt(s[s.length - 1]) - 1);
            deppCopy(a, tmp);
        }
    }

    public static void rotation(int num) {
        int idx = (num - 1) % 3;
        int obj = 0;
        int[] tmp = new int[3];

        if (num <= 3) {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[1][i][idx];
            for (int i = 0; i < 3; i++)
                a[1][i][idx] = a[2][i][idx];
            for (int i = 0; i < 3; i++)
                a[2][i][idx] = a[3][i][idx];
            for (int i = 0; i < 3; i++)
                a[3][i][idx] = a[0][i][idx];
            for (int i = 0; i < 3; i++)
                a[0][i][idx] = tmp[i];

            if (num == 1)
                obj = 4;
            else if (num == 3)
                obj = 5;
        }
        else if (num <= 6) {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[1][i][idx];
            for (int i = 0; i < 3; i++)
                a[1][i][idx] = a[0][i][idx];
            for (int i = 0; i < 3; i++)
                a[0][i][idx] = a[3][i][idx];
            for (int i = 0; i < 3; i++)
                a[3][i][idx] = a[2][i][idx];
            for (int i = 0; i < 3; i++)
                a[2][i][idx] = tmp[i];

            if (num == 4)
                obj = 4;
            else if (num == 6)
                obj = 5;
        }
        else if (num <= 9) {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[1][idx][i];
            for (int i = 0; i < 3; i++)
                a[1][idx][i] = a[5][idx][i];
            for (int i = 0; i < 3; i++)
                a[5][idx][i] = a[3][2 - idx][2 - i];
            for (int i = 0; i < 3; i++)
                a[3][2 - idx][2 - i] = a[4][idx][i];
            for (int i = 0; i < 3; i++)
                a[4][idx][i] = tmp[i];

            if (num == 7)
                obj = 0;
            else if (num == 9)
                obj = 2;
        }
        else {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[1][idx][i];
            for (int i = 0; i < 3; i++)
                a[1][idx][i] = a[4][idx][i];
            for (int i = 0; i < 3; i++)
                a[4][idx][i] = a[3][2 - idx][2 - i];
            for (int i = 0; i < 3; i++)
                a[3][2 - idx][2 - i] = a[5][idx][i];
            for (int i = 0; i < 3; i++)
                a[5][idx][i] = tmp[i];

            if (num == 10)
                obj = 0;
            else if (num == 12)
                obj = 2;
        }
        // 왼쪽
        if (num == 1 || num == 6 || num == 9 || num == 10) {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[obj][0][i];
            for (int i = 0; i < 3; i++)
                a[obj][0][i] = a[obj][i][2];
            for (int i = 0; i < 3; i++)
                a[obj][i][2] = a[obj][2][2 - i];
            for (int i = 0; i < 3; i++)
                a[obj][2][2 - i] = a[obj][2 - i][0];
            for (int i = 0; i < 3; i++)
                a[obj][2 - i][0] = tmp[i];
        }
        // 오른쪽
        else if (num == 3 || num == 4 || num == 7 || num == 12) {
            for (int i = 0; i < 3; i++)
                tmp[i] = a[obj][0][i];
            for (int i = 0; i < 3; i++)
                a[obj][0][i] = a[obj][2 - i][0];
            for (int i = 0; i < 3; i++)
                a[obj][i][0] = a[obj][2][i];
            for (int i = 0; i < 3; i++)
                a[obj][2][i] = a[obj][2 - i][2];
            for (int i = 0; i < 3; i++)
                a[obj][i][2] = tmp[i];
        }
    }

    public static void print(int c) {
        System.out.print("#" + cnt + " ");
        cnt++;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(a[c][j][k] + " ");
            }
        }
        System.out.println();
    }

    public static void deppCopy(int[][][] a, int[][][] b) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    a[i][j][k] = b[i][j][k];
                }
            }
        }
    }
}