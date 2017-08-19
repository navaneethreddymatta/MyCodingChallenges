package nav.codeChallenges;

import java.util.*;

public class CurrencyArbitrage {
    public static void main(String[] args) {
        String[] quotes = {"1.1837 1.3829 0.6102","1.1234 1.2134 1.2311"};
        int arb[] = arbitrage(quotes);
    }

    public static int[] arbitrage(String[] quotes) {
        int totalInvestment = 100000;
        int numTransactions = quotes.length;
        int profits[] = new int[numTransactions];
        for(int i = 0; i < numTransactions; i++) {
            String[] quote = quotes[i].split(" ");
            double usdPerEur = Double.parseDouble(quote[0]);
            double eurPerGbp = Double.parseDouble(quote[1]);
            double gbpPerUsd = Double.parseDouble(quote[2]);
            profits[i] = calculateArbitarage(totalInvestment, usdPerEur,eurPerGbp,gbpPerUsd);
            System.out.println(profits[i]);
        }
        return profits;
    }

    public static int calculateArbitarage(int totalInvestment, double usdPerEur,double eurPerGbp,double gbpPerUsd){
        double usdEurCost = totalInvestment/usdPerEur;
        double eurGbpCost = usdEurCost/eurPerGbp;
        double gbpUsdCost = eurGbpCost/gbpPerUsd;
        int totalProfitLoss = (int)gbpUsdCost-totalInvestment;
        int arbitarage = (totalProfitLoss<=0)?0:totalProfitLoss;
        return arbitarage;
    }
}