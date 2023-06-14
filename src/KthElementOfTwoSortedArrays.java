import java.util.Arrays;
import java.util.Random;

public class KthElementOfTwoSortedArrays {

    // most obvious solution but probably not the best T.C: O(n+m) S.C: O(n+m)
    private static int kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int[] ans = new int[n + m];
        int i = 0, j = 0;
        int ptr = 0;
        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                ans[ptr] = arr2[j];
                j++;
            } else {
                ans[ptr] = arr1[i];
                i++;
            }
            ptr++;
        }
        while (i < n) {
            ans[ptr] = arr1[i];
            i++;
            ptr++;
        }
        while (j < m) {
            ans[ptr] = arr2[j];
            j++;
            ptr++;
        }
        System.out.println("k = " + k + "\n");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(ans));
        return ans[k - 1];
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
        System.out.println(kthElement(arr1, arr2, n, m, k));
    }
}
