#include <iostream>
using namespace std;

int r, c;
char maps[22][22];
bool visited[26];
int dy[4] = { 0,0,1,-1 };
int dx[4] = { -1,1,0,0 };
int maxs = 0;

void DFS(int y, int x, int cnt) {
	if (cnt > maxs)
		maxs = cnt;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny <= 0 || ny > r || nx <= 0 || nx > c)
			continue;
		if (visited[maps[ny][nx] - 'A'])
			continue;

		visited[maps[ny][nx] - 'A'] = true;
		DFS(ny, nx, cnt + 1);
		visited[maps[ny][nx] - 'A'] = false;

	}
}

int main() {
	cin >> r >> c;

	for (int i = 1; i <= r; i++) {
		for (int j = 1; j <= c; j++) {
			scanf("%1s", &maps[i][j]);
		}
	}
	visited[maps[1][1] - 'A'] = true;
	DFS(1, 1, 1);

	printf("%d", maxs);

	return 0;
}