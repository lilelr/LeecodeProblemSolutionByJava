package problems.PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/4/15.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        res.add(firstList);
        if (numRows == 1) return res;
        List<Integer> secList = new ArrayList<>();
        secList.add(1);
        secList.add(1);
        res.add(secList);
        if (numRows == 2) return res;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> preList = res.get(i - 2);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 2; j < i; j++) {
                newList.add(preList.get(j - 2) + preList.get(j - 1));
            }
            newList.add(1);
            res.add(newList);
        }
        return res;
    }
}
