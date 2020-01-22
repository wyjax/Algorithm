#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;

int n;
char maps[101][101];
bool visited[101][101];
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, -1, 0, 1 };

void BFS(int i, int j, bool types) {
	queue<pair<int, int>> q;
	q.push({ i, j });
	visited[i][j] = true;

	while (!q.empty()) {
		i = q.front().first;
		j = q.front().second;
		q.pop();

		for (int k = 0; k < 4; k++) {
			int nx = j + dx[k];
			int ny = i + dy[k];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if (types) {
				if (maps[i][j] == 'R' || maps[i][j] == 'G') {
					if ((maps[ny][nx] == 'R' || maps[ny][nx] == 'G') && !visited[ny][nx]) {
						q.push({ ny, nx });
						visited[ny][nx] = true;
					}
				}
				else if (maps[ny][nx] == 'B' && !visited[ny][nx]) {				
					q.push({ ny, nx });
					visited[ny][nx] = true;
				}
			}
			else {
				if (!visited[ny][nx] && maps[i][j] == maps[ny][nx]) {
					q.push({ ny, nx });
					visited[ny][nx] = true;
				}
			}
		}
	}
}



int main() {
	int ans = 0;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1s", &maps[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				BFS(i, j, false);
				ans++;
			}
		}
	}
	printf("%d", ans);
	ans = 0;
	memset(visited, false, sizeof(visited));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				BFS(i, j, true);
				ans++;
			}
		}
	}
	printf(" %d\n", ans);


	return 0;
}