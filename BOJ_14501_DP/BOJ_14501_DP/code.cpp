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

		// i에 일할수도있고 i + 1만 일할 수도 있음
		dp[i + 1] = max(dp[i + 1], dp[i]);
		dp[i + t] = max(dp[i + t], dp[i] + p);

		// 1일 떄는 dp[1]이고 dp[2]부터는 dp[1]하고 dp[2] 하고 따져봐야함

	}

	printf("%d", dp[n + 1]);
	// dp[n] = n 일 때까지 얻은 수익

	return 0;
}