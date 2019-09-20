import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int arr[] = new int[26];

		String s = br.readLine();
		
		char ch = 'a';
		for(int j = 0; j < 26; j++) {
			arr[j] = -1;
			char c = (char) (j + (int)ch);
			for(int i = 0; i < s.length(); i++) {
				if(c == s.charAt(i)) {
					arr[j] = i;
					break;
				}
			}
			
			bw.write(String.valueOf(arr[j]) + " ");
		}
		
		br.close();
		bw.close();
	}
}