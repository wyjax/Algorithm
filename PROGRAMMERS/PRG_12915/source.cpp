#include <string>
#include <algorithm>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strings, int n) {
	vector<string> answer;

	for (int i = 0; i < strings.size(); i++) {
		strings[i] = strings[i].at(n) + strings[i];
	}

	sort(strings.begin(), strings.end());

	for (int i = 0; i < strings.size(); i++) {
		answer.push_back(strings[i].substr(1, strings[i].length() - 1));
	}

	return answer;
}

int main() {

	return 0;
}