import java.util.*;

/*
 *  Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *  Return the minimized largest sum of the split.
 *   A subarray is a contiguous part of the array.
 */
public class SplitArrayLargestSum {
    static int largestSumOfTheSplit(int[] nums, int k) {
        // Let us the find the possible minimum and maximum answers first;
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i : nums) {
            max += i;
            if (min < i)
                min = i;
        }
        System.out.println("Min : " + min + " & Max : " + max);
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int pieces = func(nums, mid); // The number of pieces the main array will be divided into
            if (pieces <= k) {
                // This could become a potential answer
                r = mid;
            } else {
                // This is not a potential answer
                l = mid + 1;
            }
        }
        return r; // left == right
    }

    static int func(int[] nums, int sum) {
        int pieces = 1, add = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            add += nums[i];
            if (add + nums[i + 1] > sum) {
                add = 0;
                pieces++; // got one subarray
            }
        }
        return pieces;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(1, 1000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000000);
        }
        int seed = Math.min(50, nums.length);
        int k = random.nextInt(seed) + 1;
        System.out.println("The minimized largest sum of the split : " + largestSumOfTheSplit(nums, k));
    }
}
