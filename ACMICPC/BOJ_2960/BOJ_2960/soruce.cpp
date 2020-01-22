#include <iostream>
using namespace std;

bool prime[1000];

int main() {
	int n, k, cnt = 0;
	cin >> n >> k;

	for (int i = 2; i <= n; i++) {
		for (int j = i; j <= n; j += i) {
			if (!prime[j]) {
				prime[j] = true;
				cnt++;

				if (cnt == k) {
					printf("%d", j);
					return 0;
				}
			}
		}
	}


	return 0;
}