#include <cstdio>

int main() {
	int n;
	scanf("%d", &n);

	for (int i = (n / 5); i >= 0; i--) {
		int tmp = n - (i * 5);

		if (tmp % 3 == 0) {
			printf("%d", i + (tmp / 3));
			return 0;
		}
	}

	printf("-1");

	return 0;
}