#include <iostream>
using namespace std;

int main() {
	int sum = 0, in, out, max = 0;

	for (int i = 0; i < 4; i++) {
		cin >> in >> out;

		sum -= in;
		sum += out;

		if (max < sum)
			max = sum;
	}

	cout << max;

	return 0;
}