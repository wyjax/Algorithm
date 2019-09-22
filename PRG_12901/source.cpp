#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
	string answer = "";
	int month[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	string dayday[] = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
	int days = 0;

	for (int i = 0; i < a - 1; i++) {
		days += month[i];
	}
	days += b;
	days %= 7;

	answer = dayday[days];

	return answer;
}

int main() {
	cout << solution(6, 24);

	return 0;
}