import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(t-- > 0) {
			int n[] = new int[26];
			String s = br.readLine();
			char c = s.charAt(0); 
			boolean check = true;
			
			for(int i = 0; i < s.length(); i++) {
				if(c != s.charAt(i) && n[s.charAt(i) - 'a'] > 0) {
					check = false;
					break;
				}
				
				c = s.charAt(i);
				n[c - 'a']++;				
			}
			
			if(check)
				cnt++;
		}
		
		System.out.println(cnt);
		
		br.close();
		bw.close();
	}
}