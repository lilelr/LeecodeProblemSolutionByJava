package note.dp.DecodeWays91;

import org.junit.Test;

/**
 * Created by yuxiao on 7/14/16.
 */
public class Solution {

    // [0, 1, 2, 3]
    //  1   1 2   0
    //
    // [0, 1, 2, 3, 4]
    //  1  1  2  0  1
    //  i=2 i>=0 i--
    // initial memo[4] = 1, memo[3]=1
    // memo[2] = memo[3]+ memo[4]
    public int numDecodingsBacking(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }

    // https://discuss.leetcode.com/topic/45327/java-2ms-dp-solution-with-detailed-explanation-and-inline-comments
    public int numDecoding2SecForwarding(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) {
            return 0;
        }

        int[] waysToDecode = new int[s.length() + 1];
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';

            // can't make progress, return 0
            if (prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26))) {
                return 0;
            }
            // can't use the previous value, so can only get to this state from the previous
            else if (prev == 0 || (prev * 10 + curr) > 26) {
                waysToDecode[i + 1] = waysToDecode[i];
            }
            // can't use current state, can only get to this state from i - 1 state
            else if (curr == 0) {
                waysToDecode[i + 1] = waysToDecode[i - 1];
            }
            // can get to this state from the previous two states
            else {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
            }
        }

        return waysToDecode[waysToDecode.length - 1];

    }

    @Test
    public void test() {
        String s = "1214";
        System.out.println(numDecoding2SecForwarding(s));
    }
}
