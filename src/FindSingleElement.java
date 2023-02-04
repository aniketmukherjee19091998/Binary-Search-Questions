import java.util.Arrays;

public class FindSingleElement {
    static int singleElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums[0] < nums[1])
            return nums[0];
        else if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums[nums.length - 1];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 1)
                m--;
            if (nums[m] != nums[m + 1])
                r = m;
            else
                l = m + 2;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println(Arrays.toString(nums));
        System.out.println("The element that appears once : " + singleElement(nums));
        // System.out.println(1 % 2);
    }
}
