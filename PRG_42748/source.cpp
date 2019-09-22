#include <string>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;
	vector<int> tmp;
	for (int i = 0; i < commands.size(); i++) {
		int n = commands[i][0];
		int m = commands[i][1];
		int k = commands[i][2];

		tmp.clear();

		for (int j = n - 1; j < m; j++) {
			tmp.push_back(array[j]);
		}

		sort(tmp.begin(), tmp.end());
		answer.push_back(tmp[k - 1]);
	}

	return answer;
}