#include<iostream>
#include<queue>

using namespace std;

int box[1001][1001];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
	int n, m;
	int found = 0, total = 0;
	queue<pair<int, int>> tomatos;

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> box[i][j];
			if (box[i][j] == 1)
				tomatos.push(make_pair(i, j));
			else if (box[i][j] == -1)
				total++;
	}

	pair<int, int> curr;
	int size, days = 0;
	int nextx, nexty;

	while (!tomatos.empty()) {
		// 익은 토마토의 개수
		size = tomatos.size();
		total += size;

		if (total == n * m) {
			cout << days << endl;
			break;
		}

		for (int i = 0; i < size; i++) {
			curr = tomatos.front();
			tomatos.pop();

			for (int j = 0; j < 4; j++) {
				nextx = curr.first + dx[j];
				nexty = curr.second + dy[j];

				if (nextx < 0 || nextx >= m
					|| nexty < 0 || nexty >= n
					|| box[nextx][nexty] != 0)
					continue;

				if (box[nextx][nexty] == 0) {
					box[nextx][nexty] = 1;
					tomatos.push(make_pair(nextx, nexty));
				}
			}
		}
		days++;
	}

	if (total != n * m)
		cout << "-1" << endl;

	return 0;
}