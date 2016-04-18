package problems.HappyNumber202;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/4/18.
 */
public class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;

        List<Integer> record = new ArrayList<>();
        record.add(n);
        boolean res = false;
        while (true){
            int sum=0;
            while (n!=0){
                sum +=(n%10)*(n%10);
                n /= 10;

            }

            if(sum == 1) return true;
            else{
                n = sum;
                if(record.contains(n)) {
                    return false;
                } else {
                    record.add(n);
                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(isHappy(19));
    }

}
