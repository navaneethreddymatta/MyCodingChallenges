package nav.cerner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JollyJumper {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s, result = "";
        int len = 0;
        while ((s = in.readLine()) != null) {
            String[] strArr = s.split(" ");
            if(strArr.length > 3) {
                result = "Jolly";
                len = Integer.parseInt(strArr[0]);
                for(int i = 3; i <= len; i++) {
                    if(Math.abs(Integer.parseInt(strArr[i]) - Integer.parseInt(strArr[i - 1])) != Math.abs(Integer.parseInt(strArr[i - 1]) - Integer.parseInt(strArr[i - 2])) - 1) {
                        result = "Not jolly";
                        break;
                    }
                }
            } else {
                result = "Not jolly";
            }
            System.out.println(result);
        }
    }
}
