package note.sort.CourseSchedule210;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuxiao on 4/5/16.
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class Solution {

    /// DAG   TopologicalSort O( V+E )
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) return new int[0];
        if (numCourses == 1) return new int[]{0};

        int[] ans = new int[numCourses];
        //build graph and indegree array
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
        }
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int v1 = prerequisites[i][0];
            int v2 = prerequisites[i][1];

            graph[v2].add(v1);
            indegree[v1]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                stack.push(Integer.valueOf(i));
            }
        }
        int count = 0;
        while (!stack.empty()) {
            int popval = stack.pop();
            ans[count] = popval;
            count++;
            int tmpsize = graph[popval].size();
            for (int i = 0; i < tmpsize; i++) {
                int ver = graph[popval].get(i);
                indegree[ver]--;
                if (indegree[ver] == 0) {
                    stack.push(ver);
                }
            }
        }

        if (count < numCourses) return new int[0];
        return ans;
    }
}