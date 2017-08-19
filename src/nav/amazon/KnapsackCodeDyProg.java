package nav.amazon;

import java.util.ArrayList;
import java.util.List;


public class KnapsackCodeDyProg {
    public static void main(String[] args) {
        System.out.println(knapsack(7, new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}));
    }

    public static List<Integer> knapsack(int W, int wt[], int val[]) {
        List<Integer> result = new ArrayList<>();
        int[][] table = new int[wt.length + 1][W + 1];
        int a = 0, b = 0;
        while(!(a == wt.length && b == W)) {
            table[a][0] = 0;
            table[0][b] = 0;
            if(a < wt.length)
                a++;
            if(b < W)
                b++;
        }
        for(int i = 1; i <= wt.length; i++) {
            for(int j = 1; j <= W; j++) {
                if(j < wt[i-1]) {
                    table[i][j] = table[i-1][j];
                } else {
                    table[i][j] = Math.max(val[i-1] + table[i-1][j - wt[i-1]], table[i-1][j]);
                }
            }
        }
        int i = wt.length, j = W;
        System.out.println(table[i][j]);
        while(i > 0 && j > 0) {
            if(table[i][j] == table[i-1][j]) {
                i--;
            } else {
                result.add(wt[i-1]);
                j = j - wt[i-1];
                i--;
            }
        }
        return result;
    }
}
