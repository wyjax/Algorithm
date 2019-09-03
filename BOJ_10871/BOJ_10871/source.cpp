#include <cstdio>

int main() {
	int x, n, tmp;

	scanf("%d %d", &n, &x);

	for (int i = 0; i < n; i++) {
		scanf("%d", &tmp);

		if (tmp < x)
			printf("%d ", tmp);
	}

	return 0;
}