#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int map[25][25], cnt = 0;
bool check[25][25];
int mapx[4] = { 0, 1, 0, -1 };
int mapy[4] = { -1, 0, 1, 0 };
vector<int> v;


void solve(int x, int y, int n) {
	queue<int> xq;
	queue<int> yq;
	int sum = 0;

	xq.push(x);
	yq.push(y);
	check[x][y] = true;

	while (!xq.empty()) {
		int tx = xq.front();
		int ty = yq.front();
		xq.pop();
		yq.pop();
		sum++;

		for (int i = 0; i < 4; i++) {
			int nx = mapx[i] + tx;
			int ny = mapy[i] + ty;

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (!check[nx][ny] && map[nx][ny] == 1) {
					xq.push(nx);
					yq.push(ny);

					check[nx][ny] = true;
				}
			}
		}
	}

	v.push_back(sum);
}

int main() {
	int n;
	cin >> n;
	char c;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> c;
			if (c == '1')
				map[i][j] = 1;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 1 && check[i][j] == false) {
				cnt++;
				solve(i, j, n);
			}
		}
	}

	printf("%d\n", cnt);
	sort(v.begin(), v.end());
	for (int num : v)
		printf("%d\n", num);

	return 0;
}