import java.util.*;

public class KthMissingPositiveInteger {
    static int findKthMissingPositiveInteger(int[] arr, int k) {
        int l = 0, r = arr.length;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] - 1 - mid < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l + k;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(1, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1, 1000);
        }
        Arrays.sort(nums);
        System.out.println("The kth missing positive integer is : "
                + findKthMissingPositiveInteger(nums, rand.nextInt(1, nums.length)));
    }
}
