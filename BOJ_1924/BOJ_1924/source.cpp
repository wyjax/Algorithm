#include <cstdio>

int main() {
	int x, y;
	scanf("%d %d", &x, &y);
	int days = y;

	for (int i = 1; i < x; i++) {
		if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
			days += 31;
		else if (i == 2)
			days += 28;
		else
			days += 30;
	}

	switch (days % 7) {
	case 0:
		printf("SUN");
		break;
	case 1:
		printf("MON");
		break;
	case 2:
		printf("TUE");
		break;
	case 3:
		printf("WED");
		break;
	case 4:
		printf("THU");
		break;
	case 5:
		printf("FRI");
		break;
	case 6:
		printf("SAT");
		break;
	}

	return 0;
}