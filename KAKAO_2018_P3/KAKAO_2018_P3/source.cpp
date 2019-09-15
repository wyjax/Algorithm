#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int countBits(int n) {
	int ret = 0;
	while (n) {
		// 1이면 카운트 >> 0번째 비트가 켜졌다는거다
		if (n & 1)
			++ret;
		n = n >> 1;
	}

	return ret;
}

bool comp(int a, int b) {
	// 1인 비트개수가 큰 순으로 정렬할 수 있도록 하는 코드
	int x = countBits(a), y = countBits(b);
	return x > y;
}

bool check(vector<vector<string>> relation, int rowsize, int colsize, int subset) { // subset 0000 ~ 1111
	for (int i = 0; i < rowsize - 1; i++) {
		for (int j = i + 1; j < rowsize; j++) {
			bool isSame = true;
			// subset은 후보키 4 / 0 1 2 3
			for (int k = 0; k < colsize; k++) {
				// 검사할 필요가 없는 경우 0000 / 0001 0010 0100 1000
				if ((subset & 1 << k) == 0) continue;
				// 다를 경우 break한 이유는 ex) 0110 일때 다르면 한개만 다르면 튜플은 다른거라고 할 수 있음
				if (relation[i][k] != relation[j][k]) {
					isSame = false;
					break;
				}
			}
			// subset이 유효성을 만족하지 못한다.
			if (isSame)
				return false;
		}
	}
	return true;
}

int solution(vector<vector<string>> relation) {
	int answer = 0;
	int rowsize = relation.size();	  // 행
	int colsize = relation[0].size(); // 열
	vector<int> candidates;

	// 1111 -> 10000
	for (int i = 1; i < (1 << colsize); ++i) {
		// 0000 <= 1111 < 10000 까지 검색
		if (check(relation, rowsize, colsize, i)) {
			candidates.push_back(i);
		}
	}
	// candidate는 1인 비트가 많은 순으로 정렬시킴
	sort(candidates.begin(), candidates.end(), comp);

	while (!candidates.empty()) {
		// 가장 적은거부터 가져온다 , candi는 유효성을 만족하는 것만 가지고 있다
		int n = candidates.back();
		candidates.pop_back();
		answer++;

		for (vector<int>::iterator it = candidates.begin(); it != candidates.end();) {
			// n과 it를 비트연산 했을 때 값이 n과 같다면 최소성을 만족하지 못한 것
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