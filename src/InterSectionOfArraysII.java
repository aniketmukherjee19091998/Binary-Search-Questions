import java.util.*;

public class InterSectionOfArraysII {
    static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        if (nums1.length > nums2.length) {
            Arrays.sort(nums1);
            for (int i = 0; i < nums2.length; i++) {
                if (search(nums1, nums2[i])) {
                    temp.add(nums2[i]);
                }
            }
        } else {
            Arrays.sort(nums2);
            for (int i = 0; i < nums1.length; i++) {
                if (search(nums2, nums1[i])) {
                    temp.add(nums1[i]);
                }
            }
        }
        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    private static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums1 = new int[rand.nextInt(1, 1000)];
        int[] nums2 = new int[rand.nextInt(1, 1000)];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = rand.nextInt(0, 1000);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = rand.nextInt(0, 1000);
        }
        System.out.println(
                "The intersection of two Arrays is(with repeat of same number) :\n"
                        + Arrays.toString(intersection(nums1, nums2)));
    }
}