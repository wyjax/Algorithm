#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int map[101][101];
int result[101][101];
bool check[101];
int n;

void BFS(int t) {
	queue<int> q;
	q.push(t);

	while (!q.empty()) {
		int p = q.front();
		q.pop();
		
		for (int i = 0; i < n; i++) {
			if (map[p][i] == 1 && result[t][i] == 0) {
				q.push(i);
				result[t][i] = 1;
			}
		}
	}
}

int main() {
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		BFS(i);
		memset(check, false, sizeof(check));
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", result[i][j]);
		}
		printf("\n");
	}

	return 0;
}
