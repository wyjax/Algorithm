import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int n1, n2;
		
		String tmp = "";
		for(int i = a.length() - 1; i >= 0; i--) {
			tmp += a.charAt(i);
		}
		n1 = Integer.parseInt(tmp);
		tmp = "";
		for(int i = b.length() - 1; i >= 0; i--) {
			tmp += b.charAt(i);
		}
		n2 = Integer.parseInt(tmp);
		
		System.out.println(n1 < n2 ? n2 : n1);
		
	}
}