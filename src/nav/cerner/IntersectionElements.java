package nav.cerner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class IntersectionElements {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String s;
        HashSet<String> hash = new HashSet<>();
        TreeSet<Integer> resultSet = new TreeSet<>();
        String[] inputArr, inputValues1, inputValues2, refValues;
        Iterator<Integer> itr;
        StringBuilder result = new StringBuilder();
        while((s = in.readLine()) != null) {
            resultSet.clear();
            hash.clear();
            result.setLength(0);
            inputArr = s.split(";");
            inputValues1 = inputArr[0].split(",");
            inputValues2 = inputArr[1].split(",");
            refValues = inputValues1;
            if(inputValues1.length > inputValues2.length)
                refValues = inputValues2;
            for(String s1 : inputValues1)
                hash.add(s1);
            if(refValues.equals(inputValues1))
                refValues = inputValues2;
            else
                refValues = inputValues1;
            for(String s1 : refValues) {
                if (hash.contains(s1))
                    resultSet.add(Integer.parseInt(s1));
            }
            itr = resultSet.iterator();
            while(itr.hasNext()) {
                result.append("," + itr.next());
            }
            if(result.length() > 0) {
                result = new StringBuilder(result.substring(1));
            }
            System.out.println(result);
        }
    }
}
