
class Solution {
	int answer = -1;
	
    public int solution(int N, int number) {
    	dfs(N, number, 0, 0);
        return answer;
    }
    
    public void dfs(int N, int number, int val, int cnt) {
    	if(cnt > 9)
    		return;
    	if (val == number) {
    		if(cnt < answer || answer == -1) {
    			answer = cnt;
    		}
    		return;
    	}
    	
    	int nn = 0;
    	for(int i = 0; i < 9; i++) {
    		nn = nn * 10 + N;
    		dfs(N, number, val + nn, cnt + 1 + i);
    		dfs(N, number, val - nn, cnt + 1 + i);
    		dfs(N, number, val * nn, cnt + 1 + i);
    		dfs(N, number, val / nn, cnt + 1 + i);
    	}
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().solution(5, 31168);
	}
}