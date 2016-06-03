package note.sort.MaximumGap164;

/**
 * Created by yuxiao on 16/6/3.
 */
public class PreTrieSolution {
    //https://leetcode.com/discuss/78234/java-o-n-easy-solution-using-trie-based-algorithm
    // O(n)
    private class Trie {
        boolean isNum = false;
        Trie[] nexts = new Trie[2];
    }

    int maxGap = 0;
    Integer prev = null;

    public int maximumGap(int[] nums) {
        Trie root = new Trie();

        // Build trie, takes O(n)
        for(int num : nums) {
            appendNum(root, num, 1L << 32);
        }

        // dfs of the trie, takes O(n)
        maxGap = 0;
        prev = null;
        maxGapSearch(root, 0);
        return maxGap;
    }

    private void appendNum(Trie root, int num, long currentBit) {
        if(currentBit > 0) {
            int bit = ((num & currentBit) == 0 ? 0 : 1);    // Can be either 0 or 1
            if(root.nexts[bit] == null) {
                root.nexts[bit] = new Trie();
            }
            appendNum(root.nexts[bit], num, currentBit >> 1);
        } else {
            root.isNum = true;
        }
    }

    private void maxGapSearch(Trie root, int num) {
        if(root != null) {
            if(root.isNum) {        // Reaching the leave
                if(prev != null) {
                    maxGap = Math.max(num - prev, maxGap);
                }
                prev = num;
            } else {                // haven't reached the leave yet
                maxGapSearch(root.nexts[0], num << 1);
                maxGapSearch(root.nexts[1], (num << 1) + 1);
            }
        }
    }

    //region using decimal instead of binary
    //    private class Trie {
//        Trie[] nexts = new Trie[10];
//    }
//
//    int maxGap = 0;
//    Integer prev = null;
//
//    public int maximumGap(int[] nums) {
//        Trie root = new Trie();
//
//        // Build trie, takes O(n)
//        for(int num : nums) appendNum(root, num, 1000000000);
//
//        // dfs of the trie, takes O(n)
//        maxGap = 0;
//        prev = null;
//        maxGapSearch(root, 0);
//        return maxGap;
//    }
//
//    private void appendNum(Trie root, int num, int mask) {
//        if(mask > 0) {
//            int digit = num / mask;    // Can be 0, 1, 2, ..., 9
//            if(root.nexts[digit] == null) root.nexts[digit] = new Trie();
//            appendNum(root.nexts[digit], num % mask, mask / 10);
//        }
//    }
//
//    private void maxGapSearch(Trie root, int num) {
//        if(root != null) {
//            boolean isLeave = true;
//            for(int i = 0; i < 10; i++) {
//                if(root.nexts[i] != null) {
//                    isLeave = false;
//                    maxGapSearch(root.nexts[i], num * 10 + i);
//                }
//            }
//
//            if(isLeave) {
//                if(prev != null) maxGap = Math.max(num - prev, maxGap);
//                prev = num;
//            }
//        }
//    }
    //endregion
}
