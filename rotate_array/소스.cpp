#include <iostream>
using namespace std;

int rc, w;
string matrix[100][100];

void printarr() {
	for (int i = 0; i < rc; i++) {
		for (int j = 0; j < rc; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << "\n";
	}
}

int minMul() {
	int val = (rc - 1) * 4;

	while (true) {
		bool check = true;

		for (int i = 2; i <= rc; i++) {
			int tmp = (i - 1) * 4;

			if (val % tmp > 0) {
				check = false;
				break;
			}
		}

		if (check)
			return val;
		val += 4;
	}
}

void right_rotate(int m, int n, int t) {
	int checking = 0;

	if (t < 0) {
		t *= -1;
		checking = 1;
	}

	t %= minMul();

	while (t-- > 0) {
		int row = 0, col = 0;
		string pre, cur;

		m = n = rc;

		while (row < m && col < n) {
			if (row % 2 == checking) {
				if (row + 1 == m || col + 1 == n)
					break;

				pre = matrix[row + 1][col];

				for (int i = col; i < n; i++) {
					cur = matrix[row][i];
					matrix[row][i] = pre;
					pre = cur;
				}
				row++;

				for (int i = row; i < m; i++) {
					cur = matrix[i][n - 1];
					matrix[i][n - 1] = pre;
					pre = cur;
				}
				n--;

				for (int i = n - 1; i >= col; i--) {
					cur = matrix[m - 1][i];
					matrix[m - 1][i] = pre;
					pre = cur;
				}
				m--;

				for (int i = m - 1; i >= row; i--) {
					cur = matrix[i][col];
					matrix[i][col] = pre;
					pre = cur;
				}
				col++;
			}
			else {
				if (row + 1 == m || col + 1 == n)
					break;

				pre = matrix[row + 1][n - 1];

				for (int i = n - 1; i >= col; i--) {
					cur = matrix[row][i];
					matrix[row][i] = pre;
					pre = cur;
				}
				row++;

				for (int i = row; i < m; i++) {
					cur = matrix[i][col];
					matrix[i][col] = pre;
					pre = cur;
				}
				col++;

				for (int i = col; i < n; i++) {
					cur = matrix[m - 1][i];
					matrix[m - 1][i] = pre;
					pre = cur;
				}
				m--;

				for (int i = m - 1; i >= row; i--) {
					cur = matrix[i][n - 1];
					matrix[i][n - 1] = pre;
					pre = cur;
				}
				n--;
			}
		}
	}

	printarr();
}

int main() {
	scanf("%d %d", &rc, &w);

	for (int i = 0; i < rc; i++) {
		for (int j = 0; j < rc; j++) {
			cin >> matrix[i][j];
		}
	}

	right_rotate(rc, rc, w);
	return 0;
}