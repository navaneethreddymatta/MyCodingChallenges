package nav.twitter;

import java.util.*;

public class FixedDistance {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2};
        System.out.println(fixedDistance(arr, 2));
    }
    static int fixedDistance(int[] a, int d) {
        int prevValue, nextValue, numPairs = 0;
        TreeSet<Integer> aTreeSet = new TreeSet<>();
        for(int aElement : a) {
            aTreeSet.add(aElement);
        }
        Iterator treeSetIterator = aTreeSet.iterator();
        while (treeSetIterator.hasNext()){
            int currVal = (int) treeSetIterator.next();
            prevValue =  currVal - d;
            nextValue =  currVal + d;
            if(aTreeSet.contains(prevValue))
                numPairs++;
            if(aTreeSet.contains(nextValue))
                numPairs++;
        }
        return numPairs/2;
    }
}
