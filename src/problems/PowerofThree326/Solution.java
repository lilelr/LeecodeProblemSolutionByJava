package problems.PowerofThree326;

/**
 * Created by yuxiao on 3/31/16.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 0) return false;
        if (n==3 || n==1) return true;
        double ans = Math.log10(n) / Math.log10(3);
        if(ans%1 == 0) return true;
        return  false;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        if (n==2 || n==1) return true;
        double ans = Math.log10(n) / Math.log10(2);
        if(ans%1 == 0) return true;
        return  false;
    }
}
