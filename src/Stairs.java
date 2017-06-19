public class Stairs {

    static long countWays(int n, int m)
    {
        if (n <= 1)
            return n;
        long res = 0;
        long[] mArr = new long[m];
        if(m > n)
        	return n;
        
        mArr[0] = 1;
        mArr[1] = 2;
        if(n == 1 || n == 2) {
        	return mArr[n-1];
        }
        for(int i = 2; i < m; i++) {
        	int result = 0;
        	for(int k = i-1; k >= 0; k--) {
        		result += mArr[k]; 
        	}
        	mArr[i] = result;
        }
        
        for(int i = m; i < n; i++) {   
        	res = 0;
        	for(int j = 0; j < m; j++) {        		
            	if(j == m-1) {
            		res += mArr[j];
            		mArr[j] = res;
            	} else {
            		res += mArr[j];
                	mArr[j] = mArr[j+1];
            	}
            }        	
        }
        return res;
    }   

    /* Driver program to test above function */
    public static void main (String args[])
    {
        int s = 50,m = 2;
        System.out.println("Number of ways = "+ countWays(s,m)%1000000007);
    }
}
