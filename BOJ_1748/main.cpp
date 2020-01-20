#include <iostream>
using namespace std;

int n;

int main() {
	cin >> n;

	int pivot = 10;
	int cnt = 1;
	int sum = 0;

	for (int i = 1; i <= n; i++) {
		if (i / pivot > 0) {
			pivot *= 10;
			cnt++;
		}

		sum += cnt;
	}

	printf("%d", sum);

	return 0;
}
