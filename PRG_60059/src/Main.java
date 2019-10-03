
class Solution {
	int n, m;
	public boolean solution(int [][]key, int [][]lock) {
		n = lock.length;
		m = key.length;

		int [][][]master = new int[4][n][n];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				master[0][i][j] = key[i][j];
			}
		}
		
		for(int k = 1; k < 4; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					master[k][j][n - i - 1] = master[k - 1][i][j];
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 1 - n; j < n; j++) {
				for(int k = 1 - n; k < n; k++) {
					int tmp[][] = new int[n][n];
					boolean check = true;
					
					for(int t = 0; t < n; t++) {
						for(int l = 0; l < n; l++) {							
							int x = t + j;
							int y = l + k;
							
							if(x >= 0 && x < n && y >= 0 && y < n)
								tmp[t][l] = master[i][x][y];
							
							if(tmp[t][l] == lock[t][l]) {
								check = false;
								break;
							}
						}
						
						if(!check)
							break;
					}					
					if(check) {
						return true;
					}
				}
			}
		}

		return false;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int key[][] = {{0,0,0}, {1,0,0}, {0,1,1}};
		int lock[][] = {{1,1,1}, {1,1,0}, {1,0,1}};
		System.out.println(new Solution().solution(key, lock));

	}
}