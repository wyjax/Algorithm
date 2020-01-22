#include <iostream>
using namespace std;

int main() {
	int num = 64;
	int cnt = 0;
	int x;

	cin >> x;

	while (x > 0) {
		if (num > x)
			num /= 2;
		else {
			cnt++;
			x -= num;
		}
	}

	cout << cnt;

	return 0;
}