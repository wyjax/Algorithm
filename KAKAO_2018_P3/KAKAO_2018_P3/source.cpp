#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int countBits(int n) {
	int ret = 0;
	while (n) {
		// 1�̸� ī��Ʈ >> 0��° ��Ʈ�� �����ٴ°Ŵ�
		if (n & 1)
			++ret;
		n = n >> 1;
	}

	return ret;
}

bool comp(int a, int b) {
	// 1�� ��Ʈ������ ū ������ ������ �� �ֵ��� �ϴ� �ڵ�
	int x = countBits(a), y = countBits(b);
	return x > y;
}

bool check(vector<vector<string>> relation, int rowsize, int colsize, int subset) { // subset 0000 ~ 1111
	for (int i = 0; i < rowsize - 1; i++) {
		for (int j = i + 1; j < rowsize; j++) {
			bool isSame = true;
			// subset�� �ĺ�Ű 4 / 0 1 2 3
			for (int k = 0; k < colsize; k++) {
				// �˻��� �ʿ䰡 ���� ��� 0000 / 0001 0010 0100 1000
				if ((subset & 1 << k) == 0) continue;
				// �ٸ� ��� break�� ������ ex) 0110 �϶� �ٸ��� �Ѱ��� �ٸ��� Ʃ���� �ٸ��Ŷ�� �� �� ����
				if (relation[i][k] != relation[j][k]) {
					isSame = false;
					break;
				}
			}
			// subset�� ��ȿ���� �������� ���Ѵ�.
			if (isSame)
				return false;
		}
	}
	return true;
}

int solution(vector<vector<string>> relation) {
	int answer = 0;
	int rowsize = relation.size();	  // ��
	int colsize = relation[0].size(); // ��
	vector<int> candidates;

	// 1111 -> 10000
	for (int i = 1; i < (1 << colsize); ++i) {
		// 0000 <= 1111 < 10000 ���� �˻�
		if (check(relation, rowsize, colsize, i)) {
			candidates.push_back(i);
		}
	}
	// candidate�� 1�� ��Ʈ�� ���� ������ ���Ľ�Ŵ
	sort(candidates.begin(), candidates.end(), comp);

	while (!candidates.empty()) {
		// ���� �����ź��� �����´� , candi�� ��ȿ���� �����ϴ� �͸� ������ �ִ�
		int n = candidates.back();
		candidates.pop_back();
		answer++;

		for (vector<int>::iterator it = candidates.begin(); it != candidates.end();) {
			// n�� it�� ��Ʈ���� ���� �� ���� n�� ���ٸ� �ּҼ��� �������� ���� ��
			// 1111 & 0110 = 0110
			if ((n & *it) == n)
				it = candidates.erase(it);
			else
				++it;
		}
	}

	return answer;
}

int main() {
	cout << solution({
		{"100", "ryan", "music", "2"},
		{"200", "apeach", "math", "2"},
		{"300", "tube", "computer", "3"},
		{"400", "con", "computer", "4"},
		{"500", "muzi", "music", "3"},
		{"600", "apeach", "music", "2"} });
}