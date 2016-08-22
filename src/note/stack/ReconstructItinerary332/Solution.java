package note.stack.ReconstructItinerary332;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/7/16.  Graph
 * https://leetcode.com/problems/reconstruct-itinerary/
 * <p>
 * The backtrace one only costs 14ms, while the DFS one using stack uses 22ms.
 * The backtrace methods is easy to understand and it may become the template which you can
 * apply to almost all backtrace problems.
 */
public class Solution {
    /// DFS using stack   22ms
    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return ret;

        // using hashMap to build a graph
        Map<String, List<String>> graph = new HashMap<>();
        int len = tickets.length;
        for (int i = 0; i < len; i++) {
            String startAddress = tickets[i][0];
            if (!graph.containsKey(startAddress)) {
                List<String> tmpEnds = new ArrayList<>();
                tmpEnds.add(tickets[i][1]);
                graph.put(startAddress, tmpEnds);
            } else {
                graph.get(startAddress).add(tickets[i][1]);
            }
        }

        // lexical order
        for (List<String> endlists : graph.values()) {
//            Collections.sort(endlists,Collections.reverseOrder());
            Collections.sort(endlists);

        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String peekStart = stack.peek();

            while (graph.containsKey(peekStart) && !graph.get(peekStart).isEmpty()) {
                stack.push(graph.get(peekStart).get(0));
                graph.get(peekStart).remove(0);
                peekStart = stack.peek();
            }

            ret.add(0, stack.pop());
        }

        return ret;
    }

    ///backtrace
    public List<String> findItineraryBackTracking(String[][] tickets) {
        List<String> ret = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return ret;

        Map<String, List<String>> graph = new HashMap<>();
        int len = tickets.length;
        for (int i = 0; i < len; i++) {
            String startAddress = tickets[i][0];
            if (!graph.containsKey(startAddress)) {
                List<String> tmpEnds = new ArrayList<>();
                tmpEnds.add(tickets[i][1]);
                graph.put(startAddress, tmpEnds);
            } else {
                graph.get(startAddress).add(tickets[i][1]);
            }
        }

        for (List<String> endlists : graph.values()) {
            Collections.sort(endlists);

        }

        backtrack("JFK", ret, graph);
        return ret;
    }

    /// 14ms
    public void backtrack(String current, List<String> ret, Map<String, List<String>> graph) {
        while (graph.containsKey(current) && !graph.get(current).isEmpty()) {
            String nextStart = graph.get(current).remove(0);
            backtrack(nextStart, ret, graph);
        }

        ret.add(0, current);
    }

    //region DFS using recursion 12ms
    private int length;
    private HashMap<String, ArrayList<String>> ticketMap = new HashMap<String, ArrayList<String>>();

    public List<String> findItineraryDFS(String[][] tickets) {

        length = tickets.length + 1;

        for (String[] trip : tickets) {
            if (ticketMap.containsKey(trip[0])) {
                ticketMap.get(trip[0]).add(trip[1]);
            } else {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(trip[1]);
                ticketMap.put(trip[0], arr);
            }
        }

        for (ArrayList<String> value : ticketMap.values()) {
            Collections.sort(value);
        }

        ArrayList<String> itinerary = new ArrayList<String>();
        itinerary.add("JFK");

        search("JFK", itinerary);

        return itinerary;
    }

    public boolean search(String start, ArrayList<String> itinerary) {
        if (itinerary.size() == length)
            return true;
        ArrayList<String> arr = ticketMap.get(start);
        if (arr != null) {//it's OK to continue
            for (int i = 0; i < arr.size(); ++i) {
                String end = arr.get(i);
                itinerary.add(end);
                arr.remove(i);
                if (search(end, itinerary) == false) {
                    //undo the move
                    itinerary.remove(itinerary.size() - 1);
                    arr.add(i, end);
                } else {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    //endregion


    @Test
    public void testfindItinerary() {
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
