#include <iostream>
using namespace std;

int rc, w;
int matrix[100][100];

void right_rotate(int m, int n, int t) {
	while (t-- > 0) {
		int row = 0, col = 0;
		int pre, cur;

		m = n = rc;

		while (row < m && col < n) {
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

			for (int i = n - 1; i >= 0; i--) {
				cur = matrix[m - 1][i];
				matrix[m - 1][i] = pre;
				pre = cur;
			}
			m--;

			for (int i = m - 1; i >= 0; i--) {
				cur = matrix[i][col];
				matrix[i][col] = pre;
				pre = cur;
			}
			col++;
		}
	}

	for (int i = 0; i < rc; i++) {
		for (int j = 0; j < rc; j++) {
			printf("%d ", matrix[i][j]);
		}
		printf("\n");
	}
}

void left_rotate(int m, int n, int t) {
	int row = 0, col = 0;
	int pre, cur;

	while (row < m && col < n) {
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

	for (int i = 0; i < rc; i++) {
		for (int j = 0; j < rc; j++) {
			printf("%d ", matrix[i][j]);
		}
		printf("\n");
	}
}

int main() {
	scanf("%d %d", &rc, &w);

	for (int i = 0; i < rc; i++) {
		for (int j = 0; j < rc; j++) {
			scanf("%d", &matrix[i][j]);
		}
	}

	//right_rotate(rc, rc, 2);
	left_rotate(rc, rc, 1);

	cout << endl;

	return 0;
}