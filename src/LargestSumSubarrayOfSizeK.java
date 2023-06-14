import java.util.Random;

class Compute {

    public long maxSumWithK(long a[], long n, long k) {
        long maxSum = Long.MIN_VALUE;
        long currSum = 0;
        long frontSum = 0;
        int j = 0;
        int i = 0;
        while (i < k) {
            currSum += a[i++];
        }
        maxSum = currSum;
        while (i < a.length) {
            currSum += a[i++];
            frontSum += a[j++];
            if (frontSum < 0) {
                currSum -= frontSum;
                frontSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

public class LargestSumSubarrayOfSizeK {
    public static void main(String[] args) {
        Compute computer = new Compute();
        Random random = new Random();
        long[] nums = new long[random.nextInt(1, 100001)];
        long k = random.nextInt(1, nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextLong(-100000, 100001);
        }
        System.out.println("The largest sum of the subarray containing at least " + k + " numbers is : ");
        System.out.println(computer.maxSumWithK(nums, nums.length, k));
    }
}
