package problems.ReconstructItinerary332;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/7/16.  Graph
 */
public class Solution {
   /// DFS using stack
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
            Collections.sort(endlists);

        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            String peekStart = stack.peek();

            while (graph.containsKey(peekStart) && !graph.get(peekStart).isEmpty()){
                stack.push(graph.get(peekStart).get(0));
                graph.get(peekStart).remove(0);
                peekStart=stack.peek();
            }
            ret.add(0,stack.pop());
        }

        return  ret;
    }

    @Test
    public void testfindItinerary(){
        String[][] tickets = new String[3][2];
        tickets[0][0] = "JFK";
        tickets[0][1] = "KUL";
        tickets[1][0] = "JFK";
        tickets[1][1] = "NRT";
        tickets[2][0] = "NRT";
        tickets[2][1] = "JFK";
        List<String> ret = findItinerary(tickets);
    }
}
