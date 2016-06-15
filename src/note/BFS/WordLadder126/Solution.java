package note.BFS.WordLadder126;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 6/15/16.
 */
public class Solution {
    private int pathLen;

    public class Node{
        public String label;
        public ArrayList<Node> neighbors;

        Node(String x){
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    private boolean isneighbor(String src,String dest){
        int diff=0;
        for(int i=0;i<src.length();i++){
            if(src.charAt(i) != dest.charAt(i)){
                diff++;
            }
        }
        if(diff==1) return true;
        return false;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String,Node> map = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        int wordListLen = wordList.size();
        String[] words = new String[wordListLen];
        int k=0;
        for(String str:wordList){
            words[k] = str;
            k++;
        }

        for(int i=0;i<wordListLen;i++){
            String curItem = words[i];
            for(int j=i+1;j<wordListLen;j++){
                if(isneighbor(curItem,words[j])){
                    Node curItemNode;
                    Node destItemNode;
                    if(!map.containsKey(curItem)){
                        map.put(curItem,new Node(curItem));

                    }
                    curItemNode = map.get(curItem);

                    if(!map.containsKey(words[j])){
                        map.put(words[j],new Node(words[j]));
                    }
                    destItemNode = map.get(words[j]);

                    if(!curItemNode.neighbors.contains(destItemNode)){
                        curItemNode.neighbors.add(destItemNode);
                        destItemNode.neighbors.add(curItemNode);
                    }
                }
            }

        }
        pathLen = Integer.MAX_VALUE;
        List<List<String>> res = new ArrayList<>();

        if(beginWord == null || endWord == null) return res;
        Node startNode = map.get(beginWord);
        ArrayList<Node> path = new ArrayList<>();
        dfs(startNode,endWord,res,path);
        return res;

    }

    private void dfs(Node curNode,String endWord,List<List<String>> res,ArrayList<Node> path){
        if(curNode == null) return;
        path.add(curNode);
        if(curNode.label == endWord){
            if(path.size() < pathLen){
                pathLen = path.size();
                res.clear();
                res.add(new ArrayList(path));
            }else if(path.size() == pathLen){
                res.add(new ArrayList(path));
            }
            return;
        }

        for(Node neighbor:curNode.neighbors){
            if(!path.contains(neighbor)){
                dfs(neighbor,endWord,res,new ArrayList<>(path));
            }
        }

    }


    @Test
    public void test(){
         Set<String> wordList = new HashSet<>();
        wordList.add("hot");
//        wordList.add("dot");
        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
        List<List<String>> res = findLadders("hot","dog",wordList);
    }

}
