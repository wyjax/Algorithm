

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] check = new boolean[3000];

        for (int i = 2; i < 3000; i++) {
            if (check[i]) continue;

            for (int j = i + i; j < 3000; j += i) {
                check[j] = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int idx = nums[i] + nums[j] + nums[k];
                    if (!check[idx]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,7,6,4};
        System.out.println(new Solution().solution(a));
    }
}
