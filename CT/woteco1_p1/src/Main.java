public class Main {
    public static void main(String[] args) {
        new Solution().solution(10000);
    }
}

class Solution {
    int types[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    int ans[] = new int[9];

    public int[] solution(int money){
        for(int i = 0; i < types.length; i++) {
            if (money == 0)
                break;

            ans[i] = money / types[i];
            money %= types[i];
        }

        return ans;
    }
}