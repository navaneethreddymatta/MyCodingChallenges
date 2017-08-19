package nav.amazon;

public class LongestIncreasingSubSequenceNlogNMethod {

    public int longestIncreasingSubSequence(int[] input) {
        int temp[] = new int[input.length];
        int result[] = new int[input.length];
        for(int i=0; i<result.length; i++) {
            result[i] = -1;
        }
        temp[0] = 0;
        int len = 0;
        for(int i=0; i < input.length; i++) {
            //if input[i] is less than 0th value of T then replace it there.
            if(input[temp[0]] > input[i]) {
                temp[0] = i;
            } else if(input[temp[len]] < input[i]) {
                //int index = ceilIndex(input, temp, len, input[i]);
                //temp[]
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int input[] = {3, 4, -1, 5, 8, 2, 3,12, 7,9, 10};
        LongestIncreasingSubSequenceNlogNMethod lis = new LongestIncreasingSubSequenceNlogNMethod();
        System.out.println("Maximum Length " + lis.longestIncreasingSubSequence(input));
    }
}
