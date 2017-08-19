package nav.twitter;

import java.util.ArrayList;
import java.util.List;

public class LongestPhrase {
    public static void main(String[] args) {
        int[] ip = {1,2,3,4,5};
        System.out.println(maxLength(ip, 5));
    }

    static int maxLength(int[] a, int k) {
        int sum = 0;
        List<Integer> aList = new ArrayList<>();
        for(int i: a) {
            aList.add(i);
            sum += i;
        }
        int diff = sum - k, position = 0, length = 0, max = 0;
        while(aList.size() > 0) {
            //System.out.println(aList);
            length = aList.size();
            if(diff == 0) {
                break;
            }
            if(aList.get(0) == diff) {
                position = 0;
            } else if(aList.get(length - 1) == diff) {
                position = length - 1;
            } else {
                max = aList.get(0) > aList.get(length - 1) ? 0 : length - 1;
                if(diff > aList.get(max)) {
                   position = max;
                } else {
                    position = 0;
                }
            }
            diff = diff - aList.get(position);
            aList.remove(position);
        }
        return aList.size();
    }
}
