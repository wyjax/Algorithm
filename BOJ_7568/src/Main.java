import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		int spell[][] = new int[t][2];
		int rank[] = new int[t];
		
		for(int i = 0; i < t; i++) {
			rank[i] = 1;
			spell[i][0] = sc.nextInt();
			spell[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < t; i++) {
			for(int j = 0; j < t; j++) {
				if(spell[i][0] > spell[j][0] && spell[i][1] > spell[j][1])
					rank[j]++;
			}
		}
		
		for(int i=0; i< t;i++) {		
			System.out.print(rank[i]+" ");
		}
	}
}