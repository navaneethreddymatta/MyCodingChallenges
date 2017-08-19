package nav.codeChallenges;

public class Stairs2 {
    static long countWays(int n)
    {
    	if(n <= 0)
    		return 0;
        long res = 0;
        long[] previousWays = new long[2];        
        previousWays[0] = 1;
        previousWays[1] = 2;
        if(n == 1 || n == 2) {
        	return previousWays[n-1];
        }
        
        for(int i = 2; i < n; i++) {          	
        	res = previousWays[0] + previousWays[1];
        	previousWays[0] = previousWays[1];
        	previousWays[1] = res;        	   
        }
        return res;
    }   

    /* Driver program to test above function */
    public static void main (String args[])
    {
        int s = 50;
        System.out.println("Number of ways = "+ countWays(s)%1000000007);
    }
}