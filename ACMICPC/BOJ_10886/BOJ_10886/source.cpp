#include <iostream>
using namespace std;

int main() {
	int n, cnt = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;

		if (tmp == 1)
			cnt++;
		else
			cnt--;
	}

	if (cnt > 0)
		printf("Junhee is cute!");
	else
		printf("Junhee is not cute!");

	return 0;
}