package nav.amazon;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
    public static void main(String[] args) {
        permute(new char[]{'a','b','c'});
    }

    public static void permute(char[] input) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for(char ch : input) {
            countMap.compute(ch, (key,val) -> {
                if(val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0);
    }

    public static void permuteUtil(char[] str, int count[], char result[], int level) {
        if(level == result.length) {
            printArray(result);
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            count[i]++;
        }
    }

    public static void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
