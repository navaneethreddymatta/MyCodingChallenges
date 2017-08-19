package nav.twitter;

public class SumUpSubArray {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7};
        System.out.println(subarraySum(input));
    }

    static long subarraySum (int[] arr) {
        long sum = 0;
        int arrLength = arr.length;
        /*for(int i=0; i < arrLength; i++) {
            sum += arr[i] * (i+1) * (arrLength-i);
        }*/
        int index = 0;
        while(index < arrLength/2){
            sum += (arr[index] + arr[arrLength-index-1]) * (index+1) * (arrLength-index);
            index++;
        }
        if((float)arrLength/2 != arrLength/2) {
            sum += arr[index] * (index+1) * (arrLength-index);
        }
        return sum;
    }
}
