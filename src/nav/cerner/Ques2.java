package nav.cerner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s,inputVal,inputOp;
        String[] inputArr,inputOpArr;
        Long inputVal1,inputVal2,result;
        while ((s = in.readLine()) != null) {
            inputArr = s.split(" ");
            inputVal = inputArr[0];
            inputOp = inputArr[1];
            inputOpArr = inputOp.split("[\\+\\-]");
            inputVal1 = Long.parseLong(inputVal.substring(0,inputOpArr[0].length()));
            inputVal2 = Long.parseLong(inputVal.substring(inputOpArr[0].length()));
            result = Long.valueOf(0);
            if(inputOp.indexOf('+') > -1) {
                result = inputVal1 + inputVal2;
            } else {
                result = inputVal1 - inputVal2;
            }
            System.out.println(result);
        }
    }
}
