class Solution {
    long ans[];

    public long solution(int N) {
        ans = new long[N + 1];
        ans[1] = 4;
        ans[2] = 6;

        for(int i = 3; i <= N; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }

        return ans[N];
    }
}