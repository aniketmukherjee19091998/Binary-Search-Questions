import java.util.Random;

public class SearchInRotatedSortedArrayWithDuplicates {
    static int findPivotWithDuplicates(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < r && nums[mid] > nums[mid + 1])
                return mid;
            if (mid > l && nums[mid] < nums[mid - 1])
                return mid - 1;
            /*
             * If elements at the left/right/middle are equal then just skip the element
             */
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                /*
                 * But what if the pivot is in these positions?
                 * So we should first check it
                 */
                if (nums[l] > nums[l + 1])
                    return l;
                l++;
                if (nums[r] < nums[r - 1])
                    return (r - 1);
                r--;
            } else if (nums[l] < nums[mid] || (nums[l] == nums[mid] && nums[mid] > nums[r])) {
                // Otherwise the left side is sorted then pivot is somewhere in this side
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = findPivotWithDuplicates(nums);
        if (pivot < 0)
            return search(nums, target, l, r);
        else if (target == nums[pivot])
            return pivot;
        else if (target < nums[l]) {
            l = pivot + 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        } else {
            while (l <= pivot) {
                int mid = l + (pivot - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    pivot = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 11, 13, 13, 15, 17, 17, 1, 1, 4, 6 };
        int target = new Random().nextInt(1, 17);
        System.out.println("The target : " + target + " found at : " + search(nums, target));
    }
}
