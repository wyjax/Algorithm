#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

vector<vector<int>> v;
bool visited[102];
int n, m;
int res, person, mins = 987654321;

void dfs(int start, int end, int cnt) {
	if (start == end) {
		mins = mins < cnt ? mins : cnt;
		return;
	}

	for (int i = 0; i < v[start].size(); i++) {
		if (!visited[v[start][i]]) {
			visited[start] = true;
			dfs(v[start][i], end, cnt + 1);
			visited[start] = false;
		}
	}
}

int main() {
	int ans = 987654321, a, b;

	cin >> n >> m;
	v.resize(n + 1);

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		memset(visited, false, sizeof(visited));
		res = 0;

		for (int j = 1; j <= n; j++) {
			mins = 987654321;
			if (i == j) continue;
			else {
				dfs(i, j, 0);
				res += mins;
			}
		}

		if (ans > res) {
			ans = res;
			person = i;
		}
		else if (ans == res)
			person = person < i ? person : i;
	}

	cout << person;

	return 0;
}