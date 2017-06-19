import java.util.*;

public class BalancedSmiley {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String[] res = {"(:)())()a()(()::(():())(:))):((:(a:())()()a)", ":) :):)", "coding: :( :):)", "(:a))))))))))))))))))))", "(:::::::::::::::::::::))",":a:))()(()()a)aaa::a:a:a:((()(a(a))whats up(a)","((a(a(())(:)(()aa(:))","(:)())()","just some text","())())()((a())("};
        /*Expected output:
          	YES
			YES
			YES
			NO
			YES
			NO
			NO
			YES
			YES
			NO*/
        String[] result = isBalanced(res);
        for(String a : result) {
        	System.out.println(a);
        }        
    }

    public static String[] isBalanced(String[] expression) {
		Stack<Integer> openBraceStack = new Stack<Integer>();
		Stack<Integer> openBraceWithColonStack = new Stack<Integer>();
		Stack<Integer> closedBraceWithColonStack = new Stack<Integer>();
		ArrayList<String> resultList = new ArrayList<String>();
		int tempVal = 0;
		for(String string : expression) {
			tempVal = 0;
			openBraceStack.clear();
			openBraceWithColonStack.clear();
			closedBraceWithColonStack.clear();
			char[] charArray = string.toCharArray();
			int index = 0;
			for(char ch : charArray) {
				if(ch =='(') {
					if(index == 0) {
						openBraceStack.push(index);
					}
					else {
						if(charArray[index - 1] == ':') {
							openBraceWithColonStack.push(index);
						}
						else {
							openBraceStack.push(index);
						}
					}
				}
				else if(ch ==')') {
					if(index == 0) {
						resultList.add("NO");
						tempVal = 1;
						break;
					} else {
						if(charArray[index - 1] == ':') {
							closedBraceWithColonStack.push(index);
						} else {
							if(openBraceStack.isEmpty()) {
								if(openBraceWithColonStack.isEmpty()) {
									resultList.add("NO");
									tempVal = 1;
									break;
								} else {
									openBraceWithColonStack.pop();
								}
							} else {
								openBraceStack.pop();
							}
						}
					}
				}
				index++;
			}
			if(tempVal == 1) {
				continue;
			}
			if(openBraceStack.isEmpty()) {
				resultList.add("YES");
				continue;
			} else {
				boolean tempCheck = false;
				while(!openBraceStack.isEmpty()) {
					tempCheck = true;
					if(closedBraceWithColonStack.isEmpty()) { 
						tempCheck = false;
						break;
					}
					if(openBraceStack.pop() > closedBraceWithColonStack.pop()) {
						tempCheck = false;
						break;
					}
				}
				if(tempCheck) {
					resultList.add("YES");
					continue;
				} else {
					resultList.add("NO");
					continue;
				}
			}	
		}
		String[] resultArr = new String[resultList.size()];
		resultArr = resultList.toArray(resultArr);
		return resultArr;
    }
}
	