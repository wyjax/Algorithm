#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> graph[1001];
bool check[1001];

void dfs(int start, vector<int> graph[], bool check[]) {
	check[start] = true;
	printf("%d ", start);

	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];

		if (!check[next]) {
			dfs(next, graph, check);
		}
	}
}

void bfs(int start, vector<int> graph[], bool check[]) {
	queue<int> q;
	q.push(start);

	check[start] = true;

	while (!q.empty()) {
		int tmp;
		tmp = q.front();
		q.pop();
		printf("%d ", tmp);

		for (int i = 0; i < graph[tmp].size(); i++) {
			int next = graph[tmp][i];

			if (check[next] == false) {
				q.push(next);
				check[next] = true;
			}
		}
	}
}

int main() {
	int n, m, start;
	cin >> n >> m >> start;

	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;

		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	dfs(start, graph, check);
	fill(check, check + 1001, false);
	printf("\n");
	bfs(start, graph, check);

	return 0;
}