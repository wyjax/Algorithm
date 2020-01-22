#include <iostream>
using namespace std;

int t;
int arr[12];
int opt[11];
int op[4];
int mind = 999999999, maxd = -999999999;

int cal() {
	int tmp = arr[0];
	for (int i = 1; i < t; i++) {
		if (opt[i - 1] == 0)
			tmp += arr[i];
		else if (opt[i - 1] == 1)
			tmp -= arr[i];
		else if (opt[i - 1] == 2)
			tmp *= arr[i];
		else if (opt[i - 1] == 3)
			tmp /= arr[i];
	}

	return tmp;
}
// endl 보다는 \n이 빠른데 이유는 endl은 출력버퍼를  비우기 때문에 느리다

void solve(int cnt) {
	if (cnt == (t - 1)) {
		int sum = 0;

		sum = cal();

		if (mind > sum)
			mind = sum;
		if (maxd < sum)
			maxd = sum;

		return;
	}

	for (int i = 0; i < 4; i++) {
		if (op[i] > 0) {
			opt[cnt] = i;
			op[i]--;

			solve(cnt + 1);
			op[i]++;
		}
	}
}

int main() {
	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < 4; i++) {
		cin >> op[i];
	}

	solve(0);
	printf("%d\n%d", maxd, mind);

	return 0;
}