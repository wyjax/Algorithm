class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == 'p')
        		cnt++;
        	else if(s.charAt(i) == 'y')
        		cnt--;
        }
        
        if(cnt != 0)
        	answer = false;
        
        return answer;
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
