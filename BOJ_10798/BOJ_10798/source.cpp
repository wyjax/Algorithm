#include <iostream>
using namespace std;

string arr[5];

int main() {
	int max = 0;
	for (int i = 0; i < 5; i++) {
		cin >> arr[i];

		if (max < arr[i].length())
			max = arr[i].length();
	}

	for (int i = 0; i < max; i++) {
		for (int j = 0; j < 5; j++) {
			if (i < arr[j].length())
				cout << arr[j][i];
		}
	}

	return 0;
}