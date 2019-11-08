public class Main {
    public static void main(String[] args) {
        int arr[][] = {{97, 98}, {197, 198}};
        // {97, 98}, {197, 198}       0
        // [131, 132]  [211, 212]     1
        // [99, 102]   [211, 212]    -1
        new Solution().solution(arr);
    }
}

class Solution {
    int ans[] = new int[2];
    int answer = 0;

    public int solution(int arr[][]) {
        for(int i = 0; i < arr.length; i++)
            ans[i] = solve(arr[i][0], arr[i][1]);

        if (ans[0] < 0 || ans[1] < 0)
            answer = -1;
        else if (ans[0] < ans[1])
            answer = 2;
        else if (ans[0] > ans[1])
            answer = 1;

        return answer;
    }

    public int solve(int left, int right) {
        int div = 100;
        int sumleft = 0, sumright = 0;
        int mulleft = 1, mulright = 1;

        if (left % 2 == 0 || right % 2 == 1 || left + 1 != right)
            return -1;

        while (div > 0) {
            if (left >= div) {
                int tl = left / div;
                sumleft += tl;
                mulleft *= tl;
                left %= div;
            }
            if (right >= div) {
                int tr = right / div;
                sumright += tr;
                mulright *= tr;
                right %= div;
            }
            div /= 10;
        }

        int m1 = sumleft > sumright ? sumleft : sumright;
        int m2 = mulleft > mulright ? mulleft : mulright;

        return m1 > m2 ? m1 : m2;
    }
}