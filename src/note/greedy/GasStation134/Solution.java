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

    // two points  1ms
    //Thinking the stations as a circle,
    // we start from point 0 and we want to return to point 0.
    // So we go as far as we can from point 0
    // until we can't (capacity+gas[start] >= cost[start]).
    // Then we should move our start point backward, because only we do this,
    // we can move forward(we use end pointer to abstract this concept).
    // Once the gas is enough for the cost, we continue to move forward.
    // We do this repeatedly until our end and start meet.

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int end = gas.length - 1;
        int capacity = 0;
        while (start <= end) {
            if (capacity + gas[start] >= cost[start]) {
                capacity = capacity + gas[start] - cost[start];
                start++;
            } else {
                capacity = capacity + (gas[end] - cost[end]);
                end--;
            }
        }
        return capacity >= 0 ? start % gas.length : -1;
    }

    //https://discuss.leetcode.com/topic/52642/java-1ms-o-n-simple-greedy-solution-with-explanation
    //  Java 1ms O(n) simple greedy solution with explanation
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0; //potential start
        while (start < len) {
            if (gas[start] - cost[start] < 0) {
                start += 1;
            } else {
                int sum = 0; // gas tank
                int i = start; // i is the real counter
                while (i < start + len) {
                    int pos = i % len; //pos is the position calculated based on i
                    sum += gas[pos] - cost[pos];
                    if (sum < 0) {
                        start = i + 1;
                        break;
                    } else {
                        if ((i + 1) % len == start) { //if the next point is the start
                            return start;
                        }
                        i += 1;
                    }
                }
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
