package note.backtracking.GenerateParentheses22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 4/24/16.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        StringBuffer sb = new StringBuffer();
        sb.append('(');
        backtracking(1, n * 2, 1, res, sb);
        return res;

    }


    private void backtracking(int curlen, int n, int value, List<String> res, StringBuffer sb) {
        if (curlen == n) {
            res.add(sb.toString());
            return;
        } else {
            if (value + 1 <= n / 2 && value + 1 < n - curlen) {
                sb.append('(');
                backtracking(curlen + 1, n, value + 1, res, sb);
                sb.deleteCharAt(curlen);
            }

            if (value - 1 >= 0) {
                sb.append(')');
                backtracking(curlen + 1, n, value - 1, res, sb);
                sb.deleteCharAt(curlen);
            }
        }


    }
}
