public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int[] a = new int[2000001];

        for (int i = 0; i < nums.length; i++) {
            if (a[nums[i]] > 0) continue;
            answer++;
            a[nums[i]]++;
        }
        if (answer > (nums.length) / 2)
            answer = nums.length / 2;

        return answer;
    }
}