package problems.ReconstructItinerary332;

import java.util.*;

/**
 * Created by yuxiao on 4/7/16.  Graph DFS
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new ArrayList<>();
        if(tickets == null || tickets.length==0) return ret;

        Map<String,List<String>> graph = new HashMap<>();
        int len=tickets.length;
        for(int i=0;i<len;i++){
            String startAddress = tickets[i][0];
            if(!graph.containsKey(startAddress)){
                List<String> tmpEnds = new ArrayList<>();
                tmpEnds.add(tickets[i][1]);
                graph.put(startAddress,tmpEnds);
            }else {
                graph.get(startAddress).add(tickets[i][1]);
            }
        }

        for(List<String> endlists:graph.values()){
//            Collections.sort(endlists,Collections.reverseOrder());
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            String popStart = stack.pop();
            ret.add(popStart);
            if(graph.containsKey(popStart)){
                List<String> popStartList = graph.get(popStart);
                while (!popStartList.isEmpty()){
                    String nextAddress=popStartList.get(0);
                    stack.push(nextAddress);
                    popStartList.remove(0);

                }
                graph.remove(popStart);
            }
        }

        return  ret;
    }
}
