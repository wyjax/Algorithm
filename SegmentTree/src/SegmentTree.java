public class SegmentTree {
    int[] segTree;
    int[] minTree;

    public void SegmentTree(int[] a) {
        int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1}; // 8 15 24 30
        int h = 1;
        while (h < arr.length) {
            h <<= 1;
        }
        segTree = new int[h * 2];
        minTree = new int[h * 2];

        initTree(arr, 0, arr.length - 1, 1);
        initMinTree(a, 1, 0, arr.length - 1);

        System.out.println(getMin(1, 0, 1, 0, arr.length - 1));
    }

    public int initMinTree(int[] a, int node, int left, int right) {
        if (left == right) {
            minTree[node] = a[left];
            return minTree[node];
        }

        int mid = (left + right) / 2;
        int leftMin = initMinTree(a, node * 2, left, mid);
        int rightMin = initMinTree(a, node * 2 + 1, mid + 1, right);
        minTree[node] = Math.min(leftMin, rightMin);

        return minTree[node];
    }

    public int getMin(int node, int start, int end, int left, int right) {
        if (end < left || start > right) {
            return 0;
        }
        if (left <= start && right >= end) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        int leftMin = getMin(node * 2, start, mid, left, right);
        int rightMin = getMin(node * 2 + 1, mid + 1, end, left, right);

        return Math.min(leftMin, rightMin);
    }

    public int initTree(int[] a, int left, int right, int node) {
        if (left == right) {
            return segTree[node] = a[left];
        }

        int mid = (left + right) / 2;
        segTree[node] += initTree(a, left, mid, node * 2);
        segTree[node] += initTree(a, mid + 1, right, node * 2 + 1);

        return segTree[node];
    }

    // left, right 구하고자 하는 범위 [8, 11]
    public int subSum(int node, int start, int end, int left, int right) {
        // [left, right]가 [start, end] 범위를 벗어난 경우
        if (left > end || right < start) {
            return 0;
        }
        // [left, right]가 [start, end]를 완전히 포함하는 경우
        if (left <= start && end <= right) {
            return segTree[node];
        }
        int mid = (start + end) / 2;
        return (subSum(node * 2, start, mid, left, right)
                + subSum(node * 2 + 1, mid + 1, end, left, right));
    }
}

/*
                1
              2   3
             4 5 6 7
    부모의 왼쪽 노드 = 부모 * 2
    부모의 오른쪽 노드 = 부모 * 2 + 1;
 */