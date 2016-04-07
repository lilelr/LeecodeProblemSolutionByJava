package problems.ReconstructItinerary332;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/7/16.  Graph
 *
 * The backtrace one only costs 14ms, while the DFS one using stack uses 22ms.
 * The backtrace methods is easy to understand and it may become the template which you can
 * apply to almost all backtrace problems.
 */
public class Solution {
   /// DFS using stack   22ms
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

    ///backtrace
    public List<String> findItineraryBackTracking(String[][] tickets) {
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
            Collections.sort(endlists);

        }

        backtrack("JFK",ret,graph);
        return  ret;
    }

    /// 14ms
    public void backtrack(String current,List<String> ret,Map<String,List<String>> graph){
        while (graph.containsKey(current) && !graph.get(current).isEmpty()){
            String nextStart = graph.get(current).remove(0);
            backtrack(nextStart,ret,graph);
        }

        ret.add(0,current);
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
//        List<String> ret = findItinerary(tickets);
        List<String> ret = findItineraryBackTracking(tickets);
    }
}
