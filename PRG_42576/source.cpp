#include <string>
#include <algorithm>
#include <map>
#include <vector>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	string answer = "";
	map<string, int> m;

	for (string s : participant) {
		m[s]++;
	}

	for (string s : completion) {
		m[s]--;
	}

	for (string s : participant) {
		if (m[s] > 0)
			return s;
	}

	return answer;
}

/*

string solution(vector<string> participant, vector<string> completion) {
	sort(participant.begin(), participant.end());
	sort(completion.begin(), completion.end());

	for (int i = 0; i < participant.size(); i++) {
		if (participant[i] != completion[i])
			return participant[i];
	}

	return participant[0];
}
*/