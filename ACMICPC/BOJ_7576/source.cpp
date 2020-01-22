#include <iostream>
#include <cstring>
using namespace std;

int mapp[1000][1000];
bool visited[1000][1000];
int m, n, pre_cnt = -1;

int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };

int check() {
	int tmp_cnt = 0, zero_cnt = 0;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (mapp[i][j] == 1)
				tmp_cnt++;
			else if (mapp[i][j] == 0)
				zero_cnt++;
		}
	}

	// 처음부터 다 익었을 경우
	if (pre_cnt == -1 && zero_cnt == 0)
		return -2;
	else if (tmp_cnt == pre_cnt)
		return -1;
	else if (zero_cnt == 0)
		return 1;
	// 익지 못하는 경우

	pre_cnt = tmp_cnt;

	return 0;
}

void dfs(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			continue;
		if (!visited[ny][nx] && mapp[ny][nx] == 1) {
			visited[ny][nx] = true;
			dfs(ny, nx);
		}

		if (mapp[ny][nx] == 0) {
			mapp[ny][nx] = 1;
			visited[ny][nx] = true;
		}
	}
}

int dayday() {
	int rtn = 0;

	for (int k = 0; k < 100000; k++) {
		rtn = check();
		memset(visited, false, sizeof(visited));

		if (rtn == -2)
			return 0;
		else if (rtn == -1)
			return -1;
		else if (rtn == 1)
			return k;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && mapp[i][j] == 1) {
					visited[i][j] = true;
					dfs(i, j);
				}
			}
		}
	}
}

int main() {
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> mapp[i][j];
		}
	}

	printf("%d", dayday());

	return 0;
}