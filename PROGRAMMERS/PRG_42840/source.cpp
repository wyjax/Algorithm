#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
	vector<int> answer;
	int ans1[] = { 1,2,3,4,5 }; // 5
	int ans2[] = { 2,1,2,3,2,4,2,5 }; // 8
	int ans3[] = { 3,3,1,1,2,2,4,4,5,5 }; // 10
	int cnt[3] = { 0, 0, 0 };

	for (int i = 0; i < answers.size(); i++) {
		if (ans1[i % 5] == answers[i])
			cnt[0]++;
		if (ans2[i % 8] == answers[i])
			cnt[1]++;
		if (ans3[i % 10] == answers[i])
			cnt[2]++;
	}

	int val = 0;
	for (int i = 0; i < 3; i++) {
		if (val < cnt[i])
			val = cnt[i];
	}

	for (int i = 0; i < 3; i++) {
		if (cnt[i] == val)
			answer.push_back(i + 1);
	}

	return answer;
}