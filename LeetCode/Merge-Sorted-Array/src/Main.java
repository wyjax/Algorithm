import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[nums1.length];

        for (int i = 0; i < m; i++)
            a[i] = nums1[i];
        int idx = 0;
        int midx = 0;
        int nidx = 0;
        while (midx < m && nidx < n) {
            if (a[midx] < nums2[nidx]) {
                nums1[idx++] = a[midx++];
            }
            else {
                nums1[idx++] = nums2[nidx++];
            }
        }

        for (int i = midx; i < m; i++) {
            nums1[idx++] = a[i];
        }
        for (int i = nidx; i < n; i++) {
            nums1[idx++] = nums2[i];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int m_idx = m - 1;
        int n_idx = n - 1;
        int idx = nums1.length - 1;

        while (m_idx >= 0 && n_idx >= 0) {
            if (nums1[m_idx] >= nums2[n_idx]) {
                nums1[idx--] = nums1[m_idx--];
            }
            else {
                nums1[idx--] = nums2[n_idx--];
            }
        }
        while (m_idx >= 0) {
            nums1[idx--] = nums1[m_idx--];
        }
        while (n_idx >= 0) {
            nums1[idx--] = nums2[n_idx--];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        new Solution().merge3(a, 3, b, 3);
    }
}
