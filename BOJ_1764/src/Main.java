import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		
		ArrayList<String> list = new ArrayList<>();
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			if(set.contains(str))
				list.add(str);
		}
		
		list.sort(Comparator.naturalOrder());
		
		System.out.println(list.size());
		
		for(String s : list)
			bw.write(s + "\n");
		
		br.close();
		bw.close();
	}
}
