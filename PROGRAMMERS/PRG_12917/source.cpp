#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool compare(int a, int b) {
	return a > b;
}

string solution(string s) {
	string answer = "";
	vector<int> v;

	for (int i = 0; i < s.length(); i++) {
		v.push_back((int)s.at(i));
	}
	sort(v.begin(), v.end(), compare);

	for (int num : v)
		answer += (char)num;

	return answer;
}

int main() {
	cout << solution("Zbcdefg");

	return 0;
}