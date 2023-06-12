import java.util.Random;

/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. 
Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 */
public class ShippingCapacity {

    private static int capacity(int[] weights, int days) {
        int l = 0, r = 0;
        for (int weight : weights) {
            r += weight;
            l = Math.max(l, weight);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int i = 0, sum = 0;
            int curr = 0;
            while (i < weights.length) {
                sum += weights[i];
                if (sum == mid) {
                    curr++;
                    sum = 0;
                } else if (sum > mid) {
                    curr++;
                    sum = weights[i];
                }
                i++;
            }
            if (sum != 0)
                curr++;
            if (curr <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] weights = new int[random.nextInt(1, 50001)];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextInt(1, 500);
        }

        int days = random.nextInt(1, weights.length - 1);
        System.out.println("The maximum capacity of the ship is : " + capacity(weights, days));
    }
}
