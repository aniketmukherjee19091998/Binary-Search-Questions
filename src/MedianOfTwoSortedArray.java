import java.util.Arrays;
import java.util.Random;

public class MedianOfTwoSortedArray {

    private static int median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2)
            return median(arr2, arr1);
        int l = 0, r = n1;
        while (l <= r) {
            int cut1 = (l + r) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = cut1 - 1;
            } else {
                l = cut1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr1 = new int[random.nextInt(1, 10)];
        int[] arr2 = new int[random.nextInt(1, 10)];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(1, 10);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(1, 10);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("The median of the two arrays is : " + median(arr1, arr2));
    }
}
