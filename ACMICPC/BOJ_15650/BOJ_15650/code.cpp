#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int arr[10];
int count = 0;

void visited(int cnt, int idx) {
	// 개수가 다찼을때 모두 출력
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (int i = idx; i < n; i++) {
		arr[cnt] = i + 1;
		visited(cnt + 1, i + 1);
	}
}

int main() {
	cin >> n >> m;

	visited(0, 0);

	return 0;
}