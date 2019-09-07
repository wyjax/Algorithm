#include <iostream>
using namespace std;

int main() {
	int input, cnt = 0;

	cin >> input;
	input = 1000 - input;
	
	cnt += input / 500;
	input %= 500;
	cnt += input / 100;
	input %= 100;
	cnt += input / 50;
	input %= 50;
	cnt += input / 10;
	input %= 10;
	cnt += input / 5;
	input %= 5;
	cnt += input;

	printf("%d", cnt);

	return 0;
}