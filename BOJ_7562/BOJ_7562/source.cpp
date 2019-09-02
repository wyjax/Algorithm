#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

bool ches[301][301];
int dx[] = { 1, 2, 1, 2, -1, -2, -1, -2 };
int dy[] = { -2, -1, 2, 1, -2, -1, 2, 1 };
int l = 0;

int bfs(int y1, int x1, int y2, int x2) {
	int ans = 0;
	queue<pair<pair<int, int>, int>> q;
	q.push({ { y1, x1 }, 0 });
	memset(ches, false, sizeof(ches));

	while (q.size() > 0) {
		int y = q.front().first.first;
		int x = q.front().first.second;
		int val = q.front().second;
		q.pop();

		if (val > ans)
			ans = val;
		if (x == x2 && y == y2)
			return ans;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= l || ny < 0 || ny >= l)
				continue;
			if (!ches[ny][nx]) {
				ches[ny][nx] = true;
				q.push({{ny, nx}, val + 1});
			}
		}
	}
	return ans;
}

int main() {
	int t, x1, y1, x2, y2;
	
	cin >> t;
	while (t-- > 0) {
		cin >> l >> y1 >> x1 >> y2 >> x2;

		printf("%d\n", bfs(y1, x1, y2, x2));
	}

	return 0;
}