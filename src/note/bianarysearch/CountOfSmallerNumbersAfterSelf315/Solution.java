package note.bianarysearch.CountOfSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 4/26/16.
 */
public class Solution {
     public List<Integer> countSmaller(int[] nums) {
         List<Integer> res = new ArrayList<>();
         if(nums.length==0 || nums==null) return res;
         if(nums.length==1){
             res.add(0);
             return res;
         }
         int len = nums.length;
         int[] b =new int[len];
         for(int i=0;i<len;i++){
             b[i]=nums[i];
         }

         Arrays.sort(b);
         int curLenOfb=b.length;
         for(int i=0;i<len-1;i++){
             int curItem = nums[i];
             int bsPos = binarySearch(b,curItem,curLenOfb);
             res.add(bsPos);

             for(int j=bsPos;j<curLenOfb-1;j++){
                 b[j] = b[j+1];
             }
             curLenOfb--;

         }
         res.add(0);
        return res;


    }

    public  int binarySearch(int[] nums,int val,int len){
        int left=0,right=len-1;
        int middle;
        while (left <= right){
            middle = left+(right-left)/2;
            if (nums[middle] == val){
                if (middle>left && nums[middle-1] == val){
                    right = middle-1;
                }else{
                    return middle;
                }
            }
            else if(nums[middle] <val){
                left = middle+1;
            } else{
                right = middle-1;
            }
        }
        return left;
    }
}
