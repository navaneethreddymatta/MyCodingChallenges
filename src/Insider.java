import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Insider {
	
	public static void main(String args[]) {
		String[] datafeed = {"0|1000","0|Shilpa|BUY|30000","0|Will|BUY|50000","0|Tom|BUY|40000","0|Kristi|BUY|15000","1|Kristi|BUY|11000","1|Tom|BUY|1000","1|Will|BUY|19000","1|Shilpa|BUY|25000",
			"2|1500","2|Will|SELL|7000","2|Shilpa|SELL|8000","2|Kristi|SELL|6000","2|Tom|SELL|9000","3|500","38|1000","78|Shilpa|BUY|30000",
			"79|Kristi|BUY|60000","80|1100","81|1200"};
		HashSet<FlaggedTrade> flagged_trades = new HashSet<>();
		HashMap<Integer, List<Trade>> trades = new HashMap<>();
		int currentPrice = 0;
		for(String feed:datafeed) {
			String[] feedVals = feed.split("\\|");
			int day = Integer.parseInt(feedVals[0]);
			System.out.println("[[ " + feed);
			if(feedVals.length == 2) {
				currentPrice = Integer.parseInt(feedVals[1]);
				for(int i = day-3; i < day; i++) {
					if(trades.get(i) != null) {
						List<Trade> tradeVal = trades.get(i);
						System.out.println("///"+tradeVal);
						for(Trade thisTrade : tradeVal) {
							if(flagged_trades.contains(thisTrade)) {
								System.out.println("---");
								continue;
							}
							boolean fraudolent = false;
							if(thisTrade.isBuy) {
								fraudolent = ((currentPrice - thisTrade.current_price) * thisTrade.amount) >= 5000000;
							} else {
								fraudolent = ((thisTrade.current_price - currentPrice) * thisTrade.amount) >= 5000000;
							}
							if(fraudolent) {
								flagged_trades.add(new FlaggedTrade(i, thisTrade.trader_name));
							}
						}
					} 
				}
			}
			else {		
				System.out.println(feedVals[1]);
				System.out.println((feedVals[2].length() == 3));
				System.out.println(currentPrice);
				System.out.println(feedVals[3]);
				Trade myTrade = new Trade(feedVals[1],(feedVals[2].length() == 3),currentPrice,Integer.parseInt(feedVals[3]));
				if(trades.get(day) == null) {
					trades.put(day, new ArrayList<Trade>());
				}						
				trades.get(day).add(myTrade);						
			}
		}
		System.out.println("__" + flagged_trades.size());
		List<FlaggedTrade> flTrades = new ArrayList<>();
		flTrades.addAll(flagged_trades);
		Collections.sort(flTrades, new Comparator<FlaggedTrade>() {

			@Override
			public int compare(FlaggedTrade o1, FlaggedTrade o2) {
				// TODO Auto-generated method stub				
				if(o1.day > o2.day) {
					return 1;
				} else { 
					return -1;
				}
			}
		});
		System.out.println("______________" + flTrades.size());
		String[] ftarray = new String[flTrades.size()];
		int index = 0;
		for(FlaggedTrade ft : flTrades) {
			ftarray[index++] = ft.day + "|" + ft.trader_name;
			System.out.println(ftarray[index++]);
		}		
	}
}
				
class Trade {
	String trader_name;
	int current_price, amount;
	boolean isBuy;
	public Trade(String trader_name, boolean isBuy, int currentPrice, int i) {
		super();
		this.trader_name = trader_name;
		this.isBuy = isBuy;
		this.current_price = currentPrice;
		this.amount = i;
	}
	
}

class FlaggedTrade {
	int day;
	String trader_name;

	public FlaggedTrade(int i, String trader_name) {
		super();
		this.day = i;
		this.trader_name = trader_name;
	}
	
}
