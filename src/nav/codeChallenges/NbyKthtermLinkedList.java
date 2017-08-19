package nav.codeChallenges;

import java.util.Iterator;
import java.util.LinkedList;


public class NbyKthtermLinkedList {
	public static void main(String[] args) {
		int k = 3;
		LinkedList<String> al = new LinkedList<String>();  
		al.add("A");  
		al.add("B");  
		al.add("C");  
		al.add("D");  
		al.add("E");  
		al.add("F");  
		al.add("G");  
		al.add("H");
		al.add("I");  
		al.add("J");  
		al.add("K");  
		al.add("L");  
		al.add("M");		
		int n = al.size();
		String temp;
		
		Iterator<String> itr = al.iterator();  
		while(itr.hasNext()){  
			System.out.print(itr.next() + " ");  
		}  
		System.out.println();
		System.out.println(n + "/" + k + " th term = " + n/k);
		
		Iterator<String> nItr = al.iterator();
		Iterator<String> kItr = al.iterator();
		boolean breakLoop;
		while(true) {
			int i = 0;
			breakLoop = true;
			while(nItr.hasNext()) {
				temp = nItr.next();
				i++;
				if(i%k == 0) {
					breakLoop = false;
					break;
				}
			}
			if(breakLoop) 
				break;
			System.out.print(kItr.next() + " ");
		}
	}
}