package nav.codeChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceCapacity {
	static int currentVal, numRecs;
	static List<Pair> pairList = new ArrayList<Pair>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		currentVal = Integer.parseInt(sc.next());
		numRecs = Integer.parseInt(sc.next());
		for(int i=0; i<numRecs; i++) {
			String val = sc.next();
			String[] valSplit = val.split(" ");
			Date dt1 = new Date(valSplit[0]);
			Pair pr1 = new Pair(dt1, 1);
			Date dt2 = new Date(valSplit[1]);
			Pair pr2 = new Pair(dt2, -1);
			pairList.add(pr1);
			pairList.add(pr2);
		}		
		Collections.sort(pairList, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				if(p1.getDt().before(p2.getDt())) 
					return 1;
				else 
					return -1;
			}
		});
		int max = 0, iter = 0;
		for(Pair pair : pairList) {
			iter += pair.getValue();
			if(iter > max)
				max = iter;
		}
		System.out.println(max - currentVal); 
	}
}


class Pair {
	private Date dt;
	private int value;
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Pair(Date dt, int value) {
		super();
		this.dt = dt;
		this.value = value;
	}
	
}
