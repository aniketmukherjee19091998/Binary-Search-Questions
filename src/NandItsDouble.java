import java.util.*;

public class NandItsDouble {

    static boolean checkIfExists(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (search(nums, nums[i]) && search(nums, nums[i] * 2))
                    return true;
            } else {
                zeros++;
            }
        }
        return zeros >= 2;
    }

    private static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(2, 500)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(-1000, 1000);
        }
        System.out.println("Does n and its double exist?: " + checkIfExists(nums));
    }
}
