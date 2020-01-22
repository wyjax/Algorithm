#include <iostream>
#include <string>
using namespace std;

int num_arr[10];

int main() {
	int num = 1, tmp;
	string s;
	for (int i = 0; i < 3; i++) {
		scanf("%d", &tmp);
		num *= tmp;
	}
	s = to_string(num);
	// atoi() >> string to int;

	for (int i = 0; i < s.length(); i++) {
		num_arr[s.at(i) - '0']++;
	}

	for (int i = 0; i < 10; i++)
		printf("%d\n", num_arr[i]);

	return 0;
}