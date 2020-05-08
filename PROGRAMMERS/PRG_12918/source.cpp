#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
	bool answer = true;
	int len = s.length();

	if (len != 4 && len != 6)
		return false;

	for (int i = 0; i < len; i++) {
		char c = s.at(i);

		if (c < '0' || c > '9')
			return false;
	}

	return answer;
}