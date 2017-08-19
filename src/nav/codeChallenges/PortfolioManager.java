package nav.codeChallenges;

/**
 * Created by navanee on 19-07-2017.
 */
public class PortfolioManager {
    public static void main(String[] args) {
        long op = findMax(6, "3 4 5 1 3 # 1");
        System.out.println(op);
    }

    static long findMax(int n, String tree) {
        String ipArray[] = tree.split(" ");
        int levels = (int)(Math.log(ipArray.length + 1) / Math.log(2));
        long[] sums = new long[levels];
        int sum = 0, currentLevel = 0, max = Integer.MIN_VALUE;
        int maxIndex = 1;
        for(int i = 0; i < ipArray.length; i++) {
            if(!ipArray[i].equals("#")) {
                if(i < maxIndex) {
                    sum += Integer.parseInt(ipArray[i]);
                } else {
                    if(sum > max)
                        max = sum;
                    sums[currentLevel] = sum;
                    currentLevel++;
                    maxIndex = maxIndex + (int)Math.pow(2,currentLevel);
                    sum = Integer.parseInt(ipArray[i]);
                }
            }
            if(i == ipArray.length - 1) {
                sums[currentLevel] = sum;
                if(sum > max)
                    max = sum;
            }
        }
        return findMaxSum(sums);
    }

    static long findMaxSum(long arr[])
    {
        long incl = arr[0];
        long excl = 0;
        long excl_new;

        for (int i = 1; i < arr.length; i++)
        {
            excl_new = (incl > excl) ? incl : excl;
            incl = excl + arr[i];
            excl = excl_new;
        }
        return ((incl > excl) ? incl : excl);
    }
}