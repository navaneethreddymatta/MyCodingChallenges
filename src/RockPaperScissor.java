import java.util.Scanner;

public class RockPaperScissor {
	public static char[] moves = {'R', 'S', 'P'};
	public static void main(String[] args) {
		String psInput = "PSRPSRPRSR";
		//Scanner sc = new Scanner(System.in);
		//String psInput = sc.next();
		char[] psInputArray = psInput.toCharArray(); 
		char[] userInputArray = new char[psInputArray.length];
		userInputArray[0] = 'R';
		userInputArray[1] = 'R';
		int winningScore = 0;
		char estimatedMove;
		for(int i = 0; i < psInputArray.length; i++) {
			if(i > 1) {
				estimatedMove = estimateNextMove(psInputArray[i-2], psInputArray[i-1]);
				userInputArray[i] = generateUserNextMove(estimatedMove);
			}
			String res = getWinner(psInputArray[i],userInputArray[i]);
			if(res.equals("user")) 
				winningScore++;
		}
		System.out.println(winningScore);
	}
	
	public static char estimateNextMove(char prevMove1, char prevMove2) {		
		if(prevMove1 == prevMove2) {
			return prevMove1;
		}
		else {
			for(int j = 0; j < moves.length; j++) {
				if(moves[j] != prevMove1 && moves[j] != prevMove2)
					return moves[j];
			}			
		}
		return prevMove2; 			
	}
	
	public static char generateUserNextMove(char estimatedMove) {
		if(estimatedMove == 'S') 
			return 'R';
		else if(estimatedMove == 'P')
			return 'S';
		else 
			return 'P';
	}
	
	public static String getWinner(char ps, char user) {
		if(ps == user){
			return "tie";
		} else if((ps == 'R' && user == 'S') || (ps == 'S' && user == 'P') || (ps == 'P' && user == 'R')) {
			return "ps";
		} else {
			return "user";
		}
	}
}
