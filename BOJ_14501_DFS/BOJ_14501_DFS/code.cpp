#include <iostream>
using namespace std;

int n;
int time[15];
int pay[15];
int ans = 0;

void solution(int next, int tmp) {
	if (next == n) {

		ans = (ans > tmp ? ans : tmp);
		return;
	}
	if (next > n)
		return;

	// 일 함
	solution(next + time[next], tmp + pay[next]);
	// 일 안함
	solution(next + 1, tmp);
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> time[i] >> pay[i];
	}
	solution(0, 0);

	printf("%d", ans);

	return 0;
}