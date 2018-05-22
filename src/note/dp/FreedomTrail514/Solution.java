package note.dp.FreedomTrail514;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuxiao on 5/22/18.
 */
// https://leetcode.com/problems/freedom-trail/description/
// https://leetcode.com/problems/freedom-trail/discuss/98897/Java-Clear-Solution-dfs+memoization
public class Solution {
    Map<String, Map<Integer, Integer>> memo;
    public int findRotateSteps(String ring, String key) {
        memo = new HashMap<>();
        return dfs(ring, key, 0);
    }

    private int findPos(String ring, char ch){ // find first occurrence clockwise
        return ring.indexOf(ch);
    }

    private int findBackPos(String ring, char ch){ //find first occurrence  anti-clockwise
        if(ring.charAt(0) == ch) return 0;
        for(int i = ring.length()-1;i>0;i--){
            if(ring.charAt(i) == ch) return i;
        }
        return 0;
    }

    private int dfs(String ring, String key, int i){
        if(i == key.length()) return 0;
        int res = 0;
        char ch = key.charAt(i);
        if(memo.containsKey(ring) && memo.get(ring).containsKey(i)) return memo.get(ring).get(i);
        int f = findPos(ring, ch);
        int b = findBackPos(ring, ch);
        int forward = 1+f+dfs(ring.substring(f)+ring.substring(0, f), key, i+1);
        int back = 1+ring.length()-b + dfs(ring.substring(b)+ring.substring(0, b),key, i+1);
        res = Math.min(forward, back);
        Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
        ans.put(i, res);
        memo.put(ring, ans);
        return res;
    }
}