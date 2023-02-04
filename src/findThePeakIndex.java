public class findThePeakIndex {
    static int peakIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            /*
             * The below condition will be fulfilled if we are in the ascending part of the
             * array
             * so we should find the answer between l and mid-1, mid could be the answer we
             * are looking for
             * but we still should check from "l to mid";
             * And that is why we have "r = mid" not "r = mid-1";
             */
            if (nums[mid] < nums[mid + 1])
                r = mid;
            /*
             * Now we are at the descending part of the array, so answer should lie from
             * mid+1 to r
             */
            else
                l = mid + 1;
        }
        /*
         * The loop will be terminated when l >= r
         * so l == r will be the most likely case, in that case we should get the answer
         * at l or r, because we are checking the mid elements with the above written
         * if-else condition
         */
        return l;
    }

    public static void main(String[] args) {
        // First let us make the mountain array
        int[] nums = { 0, 2, 3, 4, 5, 2, 1, 0 };
        System.out.println("The peak index is : " + peakIndex(nums));
        // int target = rand.nextInt(0, 100000);
        // System.out.println("Target : " + target);
        // System.out.println("The element is at : " + search(nums, 1));
    }
}
