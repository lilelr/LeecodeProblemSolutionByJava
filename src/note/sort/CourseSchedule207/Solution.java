package note.sort.CourseSchedule207;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuxiao on 4/5/16.
 * https://leetcode.com/problems/course-schedule/
 */
public class Solution {

    /// DAG   TopologicalSort O( V+E )
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;


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

        if (count < numCourses) return false;
        return true;
    }


    @Test
    public void testcanFinish() {
        int[][] edges = new int[2][2];
        edges[0][0] = 1;
        edges[0][1] = 0;
        edges[1][0] = 0;
        edges[1][1] = 1;
        System.out.println(canFinish(2, edges));
    }
}
