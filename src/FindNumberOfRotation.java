public class FindNumberOfRotation {

    static int findTheNumberOfRotation(int[] nums) {
        int ans = helper(nums) + 1;
        return ans;
    }

    static int helper(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < r && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > l && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[mid] <= nums[l]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 11, 12, 15, 2, 4, 7, 9 };
        System.out.println("The number of rotation : " + findTheNumberOfRotation(nums));
    }
}
