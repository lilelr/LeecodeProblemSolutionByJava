package note.BFS.CloneGraph133;

import java.util.*;

/**
 * Created by yuxiao on 6/14/16.
 * https://leetcode.com/problems/clone-graph/
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



    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return bfs(node);

    }

    public UndirectedGraphNode bfs(UndirectedGraphNode node){
        if(node ==null) return null;
        // queue  stores the nodes of old map
        Deque<UndirectedGraphNode> queue = new LinkedList<>();
        queue.push(node);
        // map respresents the clone map
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label,new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()){
            UndirectedGraphNode frontNode = queue.pop();
            // consider the adjcent nodes in priority
            for(UndirectedGraphNode neighbor: frontNode.neighbors){
                if (!map.containsKey(neighbor.label)){
                    map.put(neighbor.label,new UndirectedGraphNode(neighbor.label));
                    queue.push(neighbor);
                }
                // add the line
                map.get(frontNode.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }


}
