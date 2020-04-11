import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        if (weight[0] != 1)
            return 1;

        int sum = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }
            sum += weight[i];
        }
        return sum + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 1, 6, 2, 7, 30, 1};
        int[] b = {1, 1};

        System.out.println(new Solution().solution(a));
    }
}


// 1 1 2 3 6 7 30

// 1 2 4 7 13 20 50
// 7