#include <iostream>
using namespace std;

int main() {
	int cnt;

	for (int i = 0; i < 3; i++) {
		cnt = 0;
		for (int j = 0; j < 4; j++) {
			int tmp;
			cin >> tmp;
			if (tmp == 0)
				cnt++;
		}

		switch (cnt) {
		case 0:
			printf("E\n");
			break;
		case 1:
			printf("A\n");
			break;
		case 2:
			printf("B\n");
			break;
		case 3:
			printf("C\n");
			break;
		case 4:
			printf("D\n");
			break;
		}
	}

	return 0;
}

/*
0 4 ¸ð
1 3 µµ
2 2 °³
3 1 °É
4 0 Àµ
*/