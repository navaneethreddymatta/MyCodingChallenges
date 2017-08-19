package nav.codeChallenges;

/**
 * Created by navanee on 23-07-2017.
 */
public class ReverseIntegerReverseSum {
    public static void main(String[] args) {
        System.out.println(reverseSumIntegers(4358, 754));
    }
    static int reverseSumIntegers(int input1, int input2) {
        int reverseInput1 = reverseInput(input1);
        int reverseInput2 = reverseInput(input2);
        int sum = reverseInput1 + reverseInput2;
        return reverseInput(sum);
    }
    static int reverseInput(int num) {
        int result = 0;
        while(num > 0) {
            result = (result * 10) + (num % 10);
            num = num / 10;
        }
        return result;
    }
}
