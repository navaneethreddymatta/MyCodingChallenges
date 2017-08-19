package nav.amazon;

import static java.lang.Math.max;

public class KnapsackRecursive {
    public static void main(String[] args) {
        System.out.println(knapsack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120},3));
    }

    public static int knapsack(int W, int wt[], int val[], int n) {
        //Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W)
            return knapsack(W, wt, val, n - 1);

        // Return the maximum of two cases
        // (1) nth item included
        // (2) not included
        else
            return max(val[n-1] + knapsack(W-wt[n-1], wt, val, n-1), knapsack(W, wt, val, n-1));
    }
}
