import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int val[] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		String number = br.readLine();
		
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			int n = c - 'A';
						
			sum += val[n] + 1;
		}
		System.out.println(sum);
	}
}