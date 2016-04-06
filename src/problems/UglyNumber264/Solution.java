package problems.UglyNumber264;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 4/6/16.
 */
public class Solution {



    /// Dynamic Programming
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int i2=0,i3=0,i5=0;
        int count=1;
        while(count<=n){
            boolean flag=true;
            int nextItem = Math.min(ans.get(i2)*2,Math.min(ans.get(i3)*3,ans.get(i5)*5));
            if(nextItem == ans.get(i2)*2){
                i2++;
            }
            if(nextItem == ans.get(i3)*3){
                i3++;

            }
            if(nextItem == ans.get(i5)*5){
                i5++;

            }

                count++;
                ans.add(nextItem);


        }
        return ans.get(n-1);
    }



    @Test
    public void testnthUglyNumber(){

        System.out.println(nthUglyNumber(12));
    }
}
