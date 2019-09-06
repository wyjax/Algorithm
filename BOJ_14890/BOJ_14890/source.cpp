#include <cstdio>

int maps[101][101];
int n, l;

int main() {
	int cnt = 0;
	scanf("%d %d", &n, &l);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &maps[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		bool out = false;
		int lcnt = 1;

		for (int j = 1; j < n; j++) {			
			out = true;

			if (maps[i][j - 1] == maps[i][j])
				lcnt++;
			else if (maps[i][j - 1] + 1 == maps[i][j] && lcnt >= l) {
				lcnt = 1;
			}
			else if (maps[i][j - 1] - 1 == maps[i][j] && lcnt >= 0) {
				lcnt = 1 - l;
			}
			else {
				out = false;
				break;
			}
		}

		if (out && (lcnt >= 0))
			cnt++;

		out = false;
		lcnt = 1;

		for (int j = 1; j < n; j++) {
			out = true;

			if (maps[j - 1][i] == maps[j][i])
				lcnt++;
			else if (maps[j - 1][i] + 1 == maps[j][i] && lcnt >= l) {
				lcnt = 1;
			}
			else if (maps[j - 1][i] - 1 == maps[j][i] && lcnt >= 0) {
				lcnt = 1 - l;
			}
			else {
				out = false;
				break;
			}
		}

		if (out && (lcnt >= 0))
			cnt++;
	}
	
	printf("%d\n", cnt);

	return 0;
}