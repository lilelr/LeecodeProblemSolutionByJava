package note.twopoint.MinimumWindowSubstring76;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/22.
 */
public class Solution {

    //https://leetcode.com/discuss/82838/java-easy-understand-solution-with-o-n-complexityhttps://leetcode.com/discuss/82838/java-easy-understand-solution-with-o-n-complexity
    //the key point is that we use two pointers as the start and end
    // after every moving forward of the end pointer we check if the substring contains t.
    // if so, we update start and end if the length is shorter than min.
    // then move the start end forward because the prefix may not contribute to constructing the t.
    // we use an array as our hashtable to store the number of letters
    // the check logic ==> function contain is O(1)
    // and we obviously traverse the s no more than 2 times
    // so the runtime complexity is O(n)
    public String minWindow(String s, String t) {
        if(t.length() == 0) return "";
        if(s.length() == 0) return "";
        if(s.length()< t.length()) return "";

        int[] tmap = new int[52];
        int[] state = new int[52];
        for(char c:t.toCharArray()){
            int idx = c>'Z'?c-'a'+26:c-'A';
            ++tmap[idx];
        }

        int start =0 ,end =0;
        int lenS = s.length();
        int lenT = t.length();
        int min = lenS+1;
        for(int i=0,j=0;j<lenS;j++){
            char c = s.charAt(j);
            int idx = c>'Z'?c-'a'+26:c-'A';
            ++state[idx];
            if(isContain(tmap,state)){
                if(j+1-i < min){
                    min = j+1-i;
                    start = i;
                    end = j;
                }

                i = i+1;
                while (j+1-i >= lenT ){
                    c = s.charAt(i-1);  // decrease i-1
                    idx = c>'Z'?c-'a'+26:c-'A';
                    state[idx]--;
                    if(isContain(tmap,state)){
                        if(j+1-i < min){
                            min = j+1-i;
                            start = i;
                            end = j;
                        }
                        i++;
                    } else {
                        // Once state does not contain tmap, it means the string of the window would never contain tmap.
                        break;
                    }

                }

            }
        }

        if(min < lenS+1){
            return s.substring(start,end+1);
        } else{
            return "";
        }
    }


    public boolean isContain(int[] tmap,int[] state){
        for(int i=0;i<tmap.length;i++){
            if(state[i]<tmap[i]) return false;
        }
        return true;
    }

    @Test
    public void test(){
        String s="aboecayb";
        String t = "abc";

        String ans = minWindow(s,t);
    }

}
