package note.divideandmerge.CountofRangeSum327;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 3/27/16.
 * https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions
 */
public class Solution {
    public  int countRangeSum(int[] nums, int lower, int upper) {

        if (nums==null || nums.length ==0 || lower > upper){
            return 0;
        }


        int r = nums.length-1;
        int ans = calculate(nums,0,r,lower,upper);

        return  ans;
    }

    public  int calculate(int[] nums,int l,int r,int lower,int upper){
        if (l==r){
            return (nums[l] >= lower && nums[l] <= upper)? 1 : 0;
        } else if (l<r){
            int m = l+(r-l)/2;
            long[] prefixOfSecondArray = new long[r-m];
            long sum=0;
            for (int i=m+1;i<=r;i++){
                sum += nums[i];
                prefixOfSecondArray[i-m-1] = sum;
            }

            Arrays.sort(prefixOfSecondArray);

            sum = 0;
            int count=0;
            for(int i=m;i>=l;i--){
                sum += nums[i];
                int tempupper = bStree(prefixOfSecondArray, upper - sum + 0.5);
                int templower = bStree(prefixOfSecondArray, lower-sum-0.5);
                    count += tempupper- templower;
                if(tempupper == prefixOfSecondArray.length && templower==-1){
                    count--;
                }

            }
            return calculate(nums,l,m,lower,upper) + calculate(nums,m+1,r,lower,upper) + count;

        }else {
            return 0;
        }

    }


    public  int bStree(long[] nums, double val){
        int left=0,right=nums.length-1;
        int middle = 0;
        while (left <= right){
            middle = left + (right-left)/2;
            if (nums[middle] <= val){
                left = middle+1;
            } else{
                right = middle-1;
            }
        }
        return left;
    }





    @Test
    public  void main(){

//        int[] arrtest = {-2, 5, -1};
//        int[] arrtest = {-2};
        int[] arrtest = {-3,1,2,-2,2,-1};


        long[] arr = {-2,5,-1};
//        System.out.println(binarySearch(arr,-2));
//                System.out.println(binarySearch(arr,1000));
//        System.out.println(countRangeSum(arr,-2,2));
//        System.out.println(bStree(arr,10));
        System.out.println(calculate(arrtest,0,arrtest.length-1,-3,-1));
    }
}
