#include <string>
#include <vector>

using namespace std;

int person[31] = { 0 };

int solution(int n, vector<int> lost, vector<int> reserve) {
	int answer = 0;

	for (int i = 0; i < lost.size(); i++)
		person[lost[i]]--;
	for (int i = 0; i < reserve.size(); i++)
		person[reserve[i]]++;

	for (int i = 1; i <= n; i++) {
		if (person[i] == 1) {
			if (i > 0 && person[i - 1] < 0)
				person[i - 1]++;
			else if (i < n && person[i + 1] < 0)
				person[i + 1]++;
		}
	}

	for (int i = 1; i <= n; i++) {
		if (person[i] >= 0)
			answer++;
	}
		
	return answer;
}