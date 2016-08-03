package note.greedy.GasStation134;

import org.junit.Test;

/**
 * Created by yuxiao on 8/3/16.
 * https://leetcode.com/problems/gas-station/
 */
public class Solution {
    // 80ms
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int start = i;
                int remainGas = gas[i] - cost[i];
                int j = i + 1;
                while (j != start) {
                    if (j == gas.length) {
                        j = 0;
                    }
                    remainGas += gas[j];
                    remainGas -= cost[j];
                    if (remainGas < 0) {
                        break;
                    }

                    j++;
                    if (j == gas.length) {
                        j = 0;
                    }
                }
                if (remainGas >= 0) return start;
            }
        }

        return -1;

    }

    @Test
    public void test() {
//        int[] gas = new int[]{4, 7, 3};
//        int[] cost = new int[]{4, 7, 3};
        int[] gas = new int[]{4, 7, 1};
        int[] cost = new int[]{4, 7, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
