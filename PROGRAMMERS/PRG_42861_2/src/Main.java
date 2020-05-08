import java.util.Arrays;
import java.util.Comparator;

class Solution {
	int max = 0;
	int d[];

	public int find(int node) {
		if (node == d[node])
			return node;

		else
			return d[node] = find(d[node]);
	}

	public int solution(int n, int[][] costs) {
		// 최소 비용을 목적으로 하기에 비용순으로 정렬
		int answer = 0;
		d = new int[n];

		for (int i = 0; i < n; i++)
			d[i] = i;

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});

		for (int i = 0; i < costs.length; i++) {
			int start = find(costs[i][0]);
			int end = find(costs[i][1]);
			int cost = costs[i][2];

			if (start != end) {
				d[start] = end;
				answer += cost;
			}
		}

		return answer;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}