import java.util.HashMap;

public class HackLandElections {
	public static void main(String args[]) {
		String[] votes = {"Victor", "Veronica", "Ryan", "Dave", "Maria", "Maria", "Farah", "Farah", "Ryan", "Veronica"};
		HashMap<String, Integer> voteCount = new HashMap<>();
		for(String vote : votes) {
			if(voteCount.get(vote) == null)
				voteCount.put(vote, 1);
			else
				voteCount.put(vote, (voteCount.get(vote) + 1));
		}
		String winner = null;
		int winnerVotes = -1;
		for(String key : voteCount.keySet()) {
			if(voteCount.get(key) > winnerVotes) {
				winner = key;
				winnerVotes = voteCount.get(key);
			} else if(voteCount.get(key) == winnerVotes) {
				if(winner.compareTo(key) > 0) {
					 winner = key;
				}
			}
		}
		System.out.println(winner);
	}
}
