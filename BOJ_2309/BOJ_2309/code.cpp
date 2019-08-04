#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int arr[9] = { 0 };
	int sum = 0;

	for (int i = 0; i < size(arr); i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	// STL Á¤·Ä
	sort(arr, arr + 9);

	for (int i = 0; i < 8; i++) {
		if ((sum - arr[i]) < 100)
			continue;

		for (int j = i + 1; j < 9; j++) {

			if ((sum - arr[i] - arr[j]) == 100) {
				for (int t = 0; t < 9; t++) {
					if (t != i && t != j)
						cout << arr[t] << "\n";
				}
				return 0;
			}
		}
	}

	return 0;
}