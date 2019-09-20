import java.io.*;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = (int)br.readLine().charAt(0);
		
		
		bw.write(String.valueOf(c));
		
		br.close();
		bw.close();
	}
}