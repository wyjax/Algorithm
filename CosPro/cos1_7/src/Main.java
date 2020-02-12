class Solution {
    int solution(int[] prices) {
        int INF = 1000000001;
        int tmp = INF;
        int answer = -INF;

        for (int price : prices) {
            if (tmp != INF)
                answer = Math.max(answer, price - tmp); // 가격의 높낮이가 가장 많이 차이날 때 매도
            tmp = Math.min(tmp, price);
        }
        return answer;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices1 = {1, 2, 3};
        int ret1 = sol.solution(prices1);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int[] prices2 = {3, 1};
        int ret2 = sol.solution(prices2);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}