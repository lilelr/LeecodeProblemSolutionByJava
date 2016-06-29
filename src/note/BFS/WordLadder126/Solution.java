package note.BFS.WordLadder126;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 6/15/16.
 */
public class Solution {
    //https://leetcode.com/discuss/82139/accepted-solution-focus-readability-explanaition-approach
    private HashSet<String> words;
    private HashMap<String, Integer> visited = new HashMap<String, Integer>();
    private List<List<String>> results = new ArrayList<List<String>>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        this.words = new HashSet(wordList);

        bfs(beginWord, endWord);

        return this.results;
    }

    public void bfs(String start, String end)
    {
        Queue<Node> q = new LinkedList<Node>();

        q.offer(new Node(null,start));

        List<Node> foundLadders = new ArrayList<>();
        Integer shortestPathLevel = null;

        while(!q.isEmpty())
        {
            Node node = q.poll();

            //if this node forms a ladder longer than we already found, skip it.
            if(shortestPathLevel !=null && node.level > shortestPathLevel) continue;

            //for each word remember the level in a ladder it was first found at
            this.visited.put(node.word, node.level);

            Set<String> mutations = getPossibleMutations(node.word);

            //if current word can mutate into end word, we are done, ladder is found, it is shortest because of BSF
            if(mutations.contains(end))
            {
                foundLadders.add(node);
                shortestPathLevel = node.level;
                continue;
            }

            for(String mutation:mutations)
            {
                //if possible next word was visited in current or upper level, ignore it (it will not form a shorter ladder)
                Integer visited_level = this.visited.get(mutation);
                if(visited_level != null && visited_level <= node.level) continue;

                Node nextNode = new Node(node, mutation);
                q.offer(nextNode);
            }
        }

        //construct all ladders from found nodes
        for(Node node:foundLadders)
        {
            ArrayList<String> path = new ArrayList<>(Arrays.asList(node.word, end));
            while(node.parent != null)
            {
                node = node.parent;
                path.add(0, node.word);
            }
            results.add(path);
        }
    }

    private HashMap<String, Set<String>> possibleMutations = new HashMap<String, Set<String>>();
    private Set<String> getPossibleMutations(String word)
    {
        Set<String> mutations = possibleMutations.get(word);
        if(mutations == null)
        {
            mutations = new HashSet<String>();
            for(int i=0; i< word.length();i++)
            {
                mutations.addAll(getMutations(word,i));
            }
            possibleMutations.put(word,mutations);
        }
        return mutations;
    }

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private List<String> getMutations(String word, int charPosition)
    {
        List<String> mutations = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(word);
        char currentChar = word.charAt(charPosition);
        for(int i=0; i<alphabet.length;i++)
        {
            char newChar = alphabet[i];
            if(newChar != currentChar)
            {
                sb.setCharAt(charPosition, newChar);
                String mutation = sb.toString();
                if(this.words.contains(mutation))
                {
                    mutations.add(mutation);
                }
            }
        }
        return mutations;
    }

    private class Node{
        public final String word;
        public final Node parent;
        public final int level;

        public Node(Node parent, String word)
        {
            this.parent = parent;
            this.word = word;
            this.level = (parent==null) ? 1 : parent.level+1;
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