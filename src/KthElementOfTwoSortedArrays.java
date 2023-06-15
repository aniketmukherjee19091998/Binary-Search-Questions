import java.util.Arrays;
import java.util.Random;

public class KthElementOfTwoSortedArrays {

    // probably the most obvious solution but probably not the best T.C: O(n+m) S.C:
    // O(1)
    // we can also use extra space of O(m+n) to find the kth element as temp[k];
    private static int kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int i = 0, j = 0;
        int ptr = 0;
        int ans = -1;
        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                ans = arr2[j];
                j++;
            } else {
                ans = arr1[i];
                i++;
            }
            ++ptr;
            if (ptr == k) {
                return ans;
            }
        }
        while (i < n) {
            ans = arr1[i];
            i++;
            ++ptr;
            if (ptr == k) {
                return ans;
            }
        }
        while (j < m) {
            ans = arr2[j];
            j++;
            ++ptr;
            if (ptr == k) {
                return ans;
            }
        }
        return ans;
    }

    // The approach is exactly similar to the median of two sorted array problem.
    // T.C: O(log (min(m, n))) S.C: O(1)
    // It is probably the most optimized version, I do not know how I can optimized
    // it futher.
    private static int kthElement_bs(int[] arr1, int[] arr2, int k) {
        int m = arr1.length, n = arr2.length;
        if (m > n)
            return kthElement_bs(arr2, arr1, k);
        int l = Math.max(0, k - n), r = Math.min(k, m);
        while (l <= r) {
            int cut_1 = (l + r) >> 1;
            int cut_2 = k - cut_1;
            int l1 = (cut_1 == 0) ? Integer.MIN_VALUE : arr1[cut_1 - 1];
            int r1 = (cut_1 == m) ? Integer.MAX_VALUE : arr1[cut_1];
            int l2 = (cut_2 == 0) ? Integer.MIN_VALUE : arr2[cut_2 - 1];
            int r2 = (cut_2 == n) ? Integer.MAX_VALUE : arr2[cut_2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                r = cut_1 - 1;
            } else {
                l = cut_1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr1 = new int[random.nextInt(1, 10)];
        int[] arr2 = new int[random.nextInt(1, 10)];
        int n = arr1.length, m = arr2.length;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(0, 11);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(0, 11);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int k = random.nextInt(1, n + m - 1);
        System.out.println("k = " + k + "\n");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(kthElement(arr1, arr2, n, m, k));
        System.out.println(kthElement_bs(arr1, arr2, k));
    }
}
