#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<string> words, vector<string> queries) {
	vector<int> answer;

	for (int i = 0; i < queries.size(); i++) {
		int cnt = 0;

		for (int j = 0; j < words.size(); j++) {
			bool flag = true;
			if (words[j].length() != queries[i].length())
				continue;
			
			for (int k = 0; k < words[j].length(); k++) {
				if (queries[i].at(k) == '?') {
					continue;
				}
				if (queries[i].at(k) != words[j].at(k)) {
					flag = false;
					break;
				}
				if (k > 0 && queries[i].at(k) == '?')
					break;
			}
			if (flag)
				cnt++;
		}
		answer.push_back(cnt);
	}
	return answer;
}

int main() {
	solution({ "frodo", "front", "frost", "frozen", "frame", "kakao" }, { "fro??", "????o", "fr???", "fro???", "pro?" });

	return 0;
}