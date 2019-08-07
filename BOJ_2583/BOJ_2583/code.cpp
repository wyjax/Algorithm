#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int n, m, k, cnt = 0;
int maps[101][101];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
vector<int> v;

void BFS(int x, int y) {
	queue<pair<int, int>> q;
	int sum = 0;
	q.push({ x, y });
	maps[y][x] = 1;

	while (q.size() > 0) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		sum++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[ny][nx] == 0) {
				maps[ny][nx] = 1;
				q.push({ nx, ny });
			}
		}
	}

	v.push_back(sum);
	cnt++;
}

int main() {
	

	return 0;
}