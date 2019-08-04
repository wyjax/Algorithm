#include <iostream>
using namespace std;

int mymin = 999999;
int obj, k, len = 0;
bool btn[10];

void numDFS(int cnt, int val) {
	if (cnt > 0) {
		int two = abs(obj - val);

		int len_tmp = 0;
		for (int i = 100000; i > 0; i /= 10) {
			if (val / i > 0) {
				len_tmp++;
			}
		}

		if (mymin > (cnt + two)) {
			mymin = cnt + two;
		}
	}

	if (cnt > len + 1)
		return;

	for (int i = 0; i < 10; i++) {
		if (btn[i]) {
			if (cnt == 0)
				numDFS(cnt + 1, i);
			else {
				int tmp = 1;
				for (int i = 0; i < cnt; i++) {
					tmp *= 10;
				}
				numDFS(cnt + 1, val + (tmp * i));
			}
		}
	}
}

int main() {
	scanf("%d %d", &obj, &k);

	if (obj == 100) {
		printf("%d", 0);
		return 0;
	}

	for (int i = 0; i < 10; i++) {
		btn[i] = true;
	}

	for (int i = 0; i < k; i++) {
		int tmp;
		scanf("%d", &tmp);
		btn[tmp] = false;
	}

	int num = obj;
	for (int i = 100000; i > 0; i /= 10) {
		if (num / i > 0) {
			len++;
		}
	}

	int ret = abs(obj - 100);

	numDFS(0, 0);
	ret = (ret < mymin ? ret : mymin);
	printf("%d", ret);

	return 0;
}