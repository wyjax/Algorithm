
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid < 0) {
                    cnt++;
                }
                else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    break;
                }
            }

            if (cnt >= k) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(new Solution().solution(a, k));
    }
}
