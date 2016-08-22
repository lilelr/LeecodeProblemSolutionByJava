package note.graph.MinimumHeightTrees310;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 4/5/16. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/
 * Removing the leaves.
 */
public class Solution {

    /// O(n) n is the sum of the nodes of the tree.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        if (n == 2) {
            ans.add(0);
            ans.add(1);
            return ans;
        }

        //build graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        //initial leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.add(i);
            }
        }

        int count = n;

        while (count > 2) {
            int leasize = leaves.size();
            count -= leasize;
            List<Integer> newleaves = new ArrayList<Integer>();
            for (int i = 0; i < leasize; i++) {
                int leavenode = leaves.get(i);
                int verToleave = graph[leavenode].get(0);
                graph[verToleave].remove(Integer.valueOf(leavenode));
                if (graph[verToleave].size() == 1) {
                    newleaves.add(verToleave);
                }
            }

            leaves = newleaves;
        }
        return leaves;


    }


    @Test
    public void testfindMinHeightTrees() {
        int[][] edges = new int[5][2];
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[2][0] = 0;
        edges[2][1] = 3;
        edges[3][0] = 4;
        edges[3][1] = 3;
        edges[4][0] = 4;
        edges[4][1] = 5;
//        int[][] edges = new int[3][2];
//        edges[0][0]=0;
//        edges[0][1]=1;
//        edges[1][0]=1;
//        edges[1][1]=2;
//        edges[2][0]=1;
//        edges[2][1]=3;

        List<Integer> ret = findMinHeightTrees(6, edges);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }
}
