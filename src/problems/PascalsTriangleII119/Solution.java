package problems.PascalsTriangleII119;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/4/15.
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> res = new ArrayList<>();
        if(rowIndex==0) return res;
        if(rowIndex==1) {
            res.add(1);
            return res;
        }
        res.add(1);
        res.add(1);
        if(rowIndex==2){
            return res;
        }


        for(int j=3;j<=rowIndex;j++){
            Integer lastTerm =0;
             for(int i=0;i<=j-2;i++){
                 Integer t = res.get(i);
                 res.set(i, lastTerm + res.get(i));
                 lastTerm = t;
             }
            res.add(1);
        }
        return res;
    }

    @Test
    public void test(){
        List<Integer> ans = getRow(7);
    }

}
