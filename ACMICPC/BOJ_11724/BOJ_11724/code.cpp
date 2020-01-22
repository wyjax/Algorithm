#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, cnt = 0;
vector<vector<int>> v;
//vector<pair<int, int>> v;
bool visited[1001];

void BFS(int idx) {
	vector<int> vec;
	queue<int> q;
	q.push(idx);
	visited[idx] = true;

	while (!q.empty()) {
		int p = q.front();
		q.pop();
		vec.push_back(p);

		for (int i = 0; i < v[p].size(); i++) {
			int next = v[p][i];

			if (!visited[next]) {
				q.push(next);
				visited[next] = true;
			}
		}
	}

	for (int num : vec)
		cout << num << " ";
	cout << endl;
}

int main() {
	scanf("%d %d", &n, &m);
	v.resize(n + 1);

	for (int i = 0; i < m; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			BFS(i);
			cnt++;
		}
	}

	cout << cnt;

	return 0;
}