#include <iostream>
#include <string>
#include <algorithm>
#include <set>
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

int main() {
	set<string> s;
	s.insert("콜라");
	s.insert("사이다");

	map<string, int> m;
	m["정기"] = 1;
	m["현규"] = 3;



	for (auto i = m.begin(); i != m.end(); i++) {
		cout << i->first << " " << i->second << endl;
	}

	for (auto i : m) {
		cout << i.first << " " << i.second << endl;
	}

	cout << m["시바"];

	for (auto i : s) {
		cout << i;
	}

	for (auto i = s.begin(); i != s.end(); i++) {
		cout << *i;
	}
}