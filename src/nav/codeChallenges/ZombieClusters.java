package nav.codeChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ZombieClusters {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        String[] zombies = new String[num];
        
        for(int i=0; i< zombies.length ; i++) {
            zombies[i] = s.next();
        }
        
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < zombies.length; i++) {
            map.put(i,i);
        }
        for(int i = 0; i < zombies.length; i++) {
            char[] chrs = zombies[i].toCharArray();
            for(int j = 0; j < i; j++) {
                if(chrs[j] == 'Y') {
                    map.put(map.get(i),map.get(j));
                }
            }
        }
        Object[] lst = map.values().toArray();
        Integer[] list = Arrays.copyOf(lst, lst.length, Integer[].class);
        List<Integer> distList = new ArrayList<Integer>();
        for(int i : list) {
            if(!distList.contains(i)) {
                distList.add(i);
            }
        }
        System.out.println(distList.size());         
    }
}