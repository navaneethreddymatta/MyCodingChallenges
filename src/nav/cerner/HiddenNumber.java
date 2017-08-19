package nav.cerner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HiddenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s, result = "";
        int aVal = (int) 'a';
        while((s = in.readLine()) != null) {
            s = s.replaceAll("[^a-j]", "");
            if(s.length() > 0) {
                char[] chArr = s.toCharArray();
                for (char ch : chArr) {
                    result += "" + ((int) ch - aVal);
                }
            } else {
                result = "NONE";
            }
            System.out.println(result);
        }
    }
}
