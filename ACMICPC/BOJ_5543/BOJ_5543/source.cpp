#include <iostream>
using namespace std;

int main() {
	int ham = 2000, drink = 2000;

	for (int i = 0; i < 3; i++) {
		int tmp;
		cin >> tmp;

		if (ham > tmp)
			ham = tmp;
	}

	for (int i = 0; i < 2; i++) {
		int tmp;
		cin >> tmp;

		if (drink > tmp)
			drink = tmp;
	}

	printf("%d", ham + drink - 50);

	return 0;
}