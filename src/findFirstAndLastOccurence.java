import java.util.*;

public class findFirstAndLastOccurence {
    static int[] firstAndLastOccurence(int[] nums, int target) {
        System.out.println("Target : " + target);
        return new int[] { search(nums, target, true), search(nums, target, false) };
    }

    static int search(int[] nums, int target, boolean findFirstIndex) {
        int ans = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid])
                r = mid - 1;
            else if (target > nums[mid])
                l = mid + 1;
            else {
                ans = mid;
                if (findFirstIndex) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1, 30);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(firstAndLastOccurence(nums, random.nextInt(1, 30))));
    }
}
