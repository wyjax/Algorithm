#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int room[10][10];
int tmproom[10][10];
int nx[] = { 0, 0, 1, -1 };
int ny[] = { 1, -1, 0, 0 };
int ans;

void printmap() {
	cout << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << tmproom[i][j] << " ";
		}
		cout << endl;
	}
}

void virus(int x, int y) {
	int tx, ty;

	for (int i = 0; i < 4; i++) {
		tx = nx[i] + x;
		ty = ny[i] + y;

		if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
			if (tmproom[tx][ty] == 0) {
				tmproom[tx][ty] = 3;
				virus(tx, ty);
			}
		}
	}
}

void solution(int cnt) {
	if (cnt == 3) {
		// 맵 복사하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmproom[i][j] = room[i][j];
			}
		}

		// 바이러스 감역
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmproom[i][j] == 2) {
					virus(i, j);
				}
			}
		}

		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmproom[i][j] == 0)
					tmp++;
			}
		}

		ans = ans > tmp ? ans : tmp;
		return;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (room[i][j] == 0) {
				room[i][j] = 1;
				solution(cnt + 1);
				room[i][j] = 0;
			}
		}
	}
}

int main() {
	cin >> n >> m;
	ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> room[i][j];
		}
	}

	solution(0);
	cout << ans;

	return 0;
}