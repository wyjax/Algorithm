## 백준 2352번 : 반도체 설계

> 접근 방법

가는 포트 n개와 오는 포트 n개가 있는데 서로 꼬이게 줄을 놓으면
개수를 셀 수 없으므로 안 꼬이게 놓으면서 줄을 세는 방법을 찾아야 했다.

여러가지 생각해봤는데 for문 2개로 꼬이는 것을 찾으면 입력이 40000이기 때문에
계산을 1억 넘게 하기 때문에 timeout이 나므로 안되고 LIS를 통해서
문제를 해결해야 했다.