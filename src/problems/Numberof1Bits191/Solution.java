package problems.Numberof1Bits191;

import org.junit.Test;

/**
 * Created by yuxiao on 3/31/16.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;

        while(n!=0){
            count++;
            n &= n-1;
        }
        return count;
    }

}

