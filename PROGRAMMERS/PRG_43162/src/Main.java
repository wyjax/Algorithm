import java.util.LinkedList;
import java.util.Queue;

class Solution { 
	boolean check[];
	int [][] maps;
	int n;
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        maps = computers;
        
        check = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	if(!check[i]) {
        		check[i] = true;
        		bfs(i);
        		answer++;
        	}
        }
        return answer;
    }
    
    public void bfs(int idx) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(idx);
    	
    	while(q.size() > 0) {
    		int first = q.peek();
    		q.remove();
    		
    		for(int i = 0; i < n; i++) {
    			if(!check[i] && maps[first][i] == 1) {
    				check[i] = true;
    				q.add(i);
    			}
    		}
    	}
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
