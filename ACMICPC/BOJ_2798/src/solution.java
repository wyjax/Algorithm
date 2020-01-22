import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;

		n = sc.nextInt();
		m = sc.nextInt();

		int arr[] = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = 0;

		for(int i = 0; i < n - 2; i++) {
			int sum = arr[i];
			for(int j = i + 1; j < n - 1; j++) {
				sum += arr[j];
				for(int k = j + 1; k < n; k++) {
					sum += arr[k];
					
					if(sum <= m && sum > ans) {
						ans = sum;
						if (ans == m) {
							System.out.println(ans);
							return;
						}
					}											
					
					sum -= arr[k];
				}
				sum -= arr[j];
			}
		}
		
		System.out.println(ans);
	}
}
