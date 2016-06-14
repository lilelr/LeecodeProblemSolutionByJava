package note.DFS.CloneGraph133;

import java.util.*;

/**
 * Created by yuxiao on 6/14/16.
 */
public class Solution {
    // https://leetcode.com/problems/clone-graph/
    //     * Definition for undirected graph.
    public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode startNode = new UndirectedGraphNode(node.label);
        map.put(startNode.label, startNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            startNode.neighbors.add(dfs(neighbor, map));
        }
        return startNode;
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);

    }

    public UndirectedGraphNode bfs(UndirectedGraphNode node){
        if(node ==null) return null;

        Deque<UndirectedGraphNode> queue = new LinkedList<>();
        queue.push(node);
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label,new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()){
            UndirectedGraphNode frontNode = queue.pop();
            for(UndirectedGraphNode neighbor: frontNode.neighbors){
                if (!map.containsKey(neighbor.label)){
                    map.put(neighbor.label,new UndirectedGraphNode(neighbor.label));
                    queue.push(neighbor);
                }
                map.get(frontNode.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }


}
