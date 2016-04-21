package note.twopoint.MergeSortedArray88;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/21.
 */
public class Solution {

//    O(n) space
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
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

    // Since we have assume that nums1 have enough space (size that is equal er greater than m+n),
    // iterate backforward using two points is simple and easy.
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n, p1 = m-1, p2 = n-1;
        while(--p>=0) {
            if(p1<0 || (p2>=0 && nums1[p1]<nums2[p2])) nums1[p] = nums2[p2--];
            else nums1[p] = nums1[p1--];
        }
    }

    @Test
    public void test(){
        int[] nums1 = {0};
        int[] nums2 ={2,5,10};
        merge(nums1,0,nums2,3);
    }
}
