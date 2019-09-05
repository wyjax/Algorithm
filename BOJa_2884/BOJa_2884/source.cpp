#include <iostream>
using namespace std;

int main() {
	int h, m;
	cin >> h >> m;

	int tmp = m - 45;

	if (tmp < 0) {
		h -= 1;
		if (h < 0)
			h = 23;

		m = 60 + tmp;
	}
	else
		m = tmp;

	printf("%d %d\n", h, m);

	return 0;
}