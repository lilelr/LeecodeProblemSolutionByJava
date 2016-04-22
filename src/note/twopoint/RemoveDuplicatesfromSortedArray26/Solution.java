package note.twopoint.RemoveDuplicatesfromSortedArray26;

/**
 * Created by yuxiao on 16/4/22.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if(len ==0) return 0;
        int res=1;
        int p1=0,p2=1;
        while (p2<len){
            while ( p2<len && nums[p2] == nums[p1] ){
                p2++;
            }
            if(p2==len) break;
            nums[++p1] = nums[p2];
            p2++;
        }

        return p1+1;



    }

}
