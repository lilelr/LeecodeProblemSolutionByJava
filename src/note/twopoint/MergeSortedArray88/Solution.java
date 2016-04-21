package note.twopoint.MergeSortedArray88;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/21.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
           int lenM = m;
           int lenN = n;
           if(lenN == 0) return;
         int[] newm = new int[lenM];
        for(int i=0;i<lenM;i++){
            newm[i] = nums1[i];
        }
          int iM=0,iN=0;
         int k=0;
        nums1 = new int[m+n];
          while (iM<lenM && iN <lenN){
              if(newm[iM] < nums2[iN]){
                 nums1[k++] = newm[iM];
                  iM++;
              } else{
                  nums1[k++] = nums2[iN];
                  iN++;
              }
          }

         if(iM == lenM){
             while (iN<lenN){
                 nums1[k++] = nums2[iN];
                 iN++;
             }
         } else{
             while (iM<lenM){
                 nums1[k++] = newm[iM];
                 iM++;
             }
         }

    }

    @Test
    public void test(){
        int[] nums1 = {0};
        int[] nums2 ={2,5,10};
        merge(nums1,0,nums2,3);
    }
}
