#include <iostream>
using namespace std;

int main() {
	int ans = 99, n;
	cin >> n;

	if (n < 100) {
		cout << n;
		return 0;
	}

	for (int i = 100; i <= n; i++) {
		int a = i % 10;
		int b = i % 100 / 10;
		int c = i % 1000 / 100;

		if ((a - b) == (b - c) && i != 1000) {
			ans++;
		}

	}
	cout << ans;

	return 0;
}