import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int size;
    public static int[][] quadTree;
    public static StringBuilder sb;
    public static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            size = Integer.parseInt(st.nextToken());
            quadTree = new int[size][size];
            sb = new StringBuilder();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    quadTree[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + cnt++ + " ");
            divquadTree(0, 0, size);
            System.out.println(sb.toString());
        }
    }

    public static boolean isAble(int row, int col, int size) {
        int t = quadTree[row][col];
        int maxA = 0;
        int maxB0 = 0, maxB1 = 0, maxB2 = 0, maxB3 = 0;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (maxA < quadTree[i][j])
                    maxA = quadTree[i][j];
            }
        }

        for (int i = row; i < row + (size / 2); i++) {
            for (int j = col; j < col + (size / 2); j++) {
                if (maxB0 < quadTree[i][j])
                    maxB0 = quadTree[i][j];
            }
        }
        for (int i = row; i < row + (size / 2); i++) {
            for (int j = col + (size / 2); j < col + size; j++) {
                if (maxB1 < quadTree[i][j])
                    maxB1 = quadTree[i][j];
            }
        }
        for (int i = row + (size / 2); i < row + size; i++) {
            for (int j = col; j < col + (size / 2); j++) {
                if (maxB2 < quadTree[i][j])
                    maxB2 = quadTree[i][j];
            }
        }
        for (int i = row + (size / 2); i < row + size; i++) {
            for (int j = col + (size / 2); j < col + size; j++) {
                if (maxB3 < quadTree[i][j])
                    maxB3 = quadTree[i][j];
            }
        }
        maxB0 = (maxB0 < maxB1) ? maxB0 : maxB1;
        maxB2 = (maxB2 < maxB3) ? maxB2 : maxB3;
        maxB0 = (maxB0 < maxB2) ? maxB0 : maxB2;

        // 분할
        if (maxA <= (maxB0 * 1.2))
            return false;

        return true;
    }

    public static void divquadTree(int row, int col, int size) {
        if (size == 2)
            return;
        if (isAble(row, col, size)) {
            sb.append(0);
        }
        else {
            sb.append(1);
            int newSize = size / 2;

            divquadTree(row, col, newSize);
            divquadTree(row, col + newSize, newSize);
            divquadTree(row + newSize, col, newSize);
            divquadTree(row + newSize, col + newSize, newSize);
        }
    }
}
