#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[30];
int t, p;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> t >> p;

		// i�� ���Ҽ����ְ� i + 1�� ���� ���� ����
		dp[i + 1] = max(dp[i + 1], dp[i]);
		dp[i + t] = max(dp[i + t], dp[i] + p);

		// 1�� ���� dp[1]�̰� dp[2]���ʹ� dp[1]�ϰ� dp[2] �ϰ� ����������

	}

	printf("%d", dp[n + 1]);
	// dp[n] = n �� ������ ���� ����

	return 0;
}