package nav.codeChallenges;

import java.util.Scanner;

/**
 * Created by navanee on 23-07-2017.
 */
public class CoinPickGame {
    public static void main(String[] args) {
        Scanner inscanner = new Scanner(System.in);
        int numTests = Integer.parseInt(inscanner.nextLine());
        String[] result = new String[numTests];
        for(int i = 0; i < numTests; i++) {
            String numCoins = inscanner.nextLine();
            result[i] = findWinner(Integer.parseInt(numCoins));
        }
        for(String s : result) {
            System.out.println(s);
        }
    }
    static String findWinner(int numCoins) {
        //double resultValue = (Math.log(numCoins) / Math.log(3));
        double resultValue = (double)numCoins / 3;
        if(resultValue != 0 && resultValue == (int) resultValue) {
            return "Ragini";
        }
        return "Hemlata";
    }
}
