public class Main {
    public static void main(String[] args) {
        int lands[][] = {{10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};
        int wells[][] = {{10, 10, 30, 30}, {40, 10, 50, 20}};
        int point[] = {15, 15, 25, 25};
        System.out.println(new Solution().solution(lands, wells, point));
        /*
        [[10, 0, 30, 5], [0, 30, 20, 50], [30, 30, 40, 40]]  [[15, 15, 25, 25], [40, 10, 50, 20]] [10, 10, 30, 30]    true
        [[0, 0, 20, 10], [10, 20, 20, 40], [30, 0, 50, 20]]  [[20, 40, 30, 50], [30, 20, 50, 30]] [20, 30, 30, 40]    false

         */
    }
}

class Solution {
    boolean answer = false;

    public boolean solution(int [][]lands, int [][]wells, int[]point) {
        int x1 = point[0];
        int y1 = point[1];
        int x2 = point[2];
        int y2 = point[3];

        for(int i = 0; i < lands.length; i++) {
            int tx1 = lands[i][0];
            int ty1 = lands[i][1];
            int tx2 = lands[i][2];
            int ty2 = lands[i][3];

            if (x1 < tx1 && y1 < ty1 && x2 > tx2 & y2 > ty2)
                return false;
            else if (x1 > tx1 && y1 > ty1 && x1 < tx2 && y1 < ty2)
                return false;
            else if (x2 > tx1 && y2 > ty1 && x2 < tx2 && y2 < ty2)
                return false;
            else if (x1 > tx1 && y1 > ty1 && x2 < tx2 && y2 < ty2)
                return false;
        }

        for(int i = 0; i < wells.length; i++) {
            int tx1 = wells[i][0];
            int ty1 = wells[i][1];
            int tx2 = wells[i][2];
            int ty2 = wells[i][3];

            if (tx1 < x1 && ty1 < y1 && tx2 > x2 & ty2 > y2)
                return true;
            else if (tx1 > x1 && ty1 > y1 && tx1 < x2 && ty1 < y2)
                return true;
            else if (tx2 > x1 && ty2 > y1 && tx2 < x2 && ty2 < y2)
                return true;
            else if (tx1 > x1 && ty1 > y1 && tx2 < x2 && ty2 < y2)
                return true;
        }

        return answer;
    }
}