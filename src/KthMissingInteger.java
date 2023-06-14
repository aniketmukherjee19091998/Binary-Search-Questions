public class KthMissingInteger {
    private static int kthMissing(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] - 1 - k < mid) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l + k;
    }

    private static int func(int[] arr, int k) {
        int count = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] != i)
                count++;
            if (count == k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 6, 9 };
        int k = 2;
        System.out.println("Then the " + k + "-th missing integer is : ");
        System.out.println(kthMissing(arr, k));
        System.out.println(func(arr, k));
    }
}
