class Solution {
    public long solution(long num) {
        // Write code here.
        long answer = 0;

        num++;
        int div = 1;
        while (num > 0) {
            long tmp = num % 10;
            if (tmp == 0)
                tmp++;
            answer += tmp * div;
            num /= 10;
            div *= 10;
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        long num = 88;
        long ret = sol.solution(num);
        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}