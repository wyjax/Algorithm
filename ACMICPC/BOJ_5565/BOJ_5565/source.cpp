#include <iostream>
using namespace std;

int main() {
	int sum;
	cin >> sum;

	for (int i = 0; i < 9; i++) {
		int tmp;
		cin >> tmp;
		sum -= tmp;
	}

	printf("%d", sum);

	return 0;
}