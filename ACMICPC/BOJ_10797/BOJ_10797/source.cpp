#include <iostream>
using namespace std;

int main() {
	int n, cnt = 0;

	cin >> n;
	for (int i = 0; i < 5; i++) {
		int tmp;
		cin >> tmp;

		if (tmp == n)
			cnt++;
	}

	cout << cnt;

	return 0;
}