import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yuxiao on 3/27/16.
 */
public class Solution {
    public static  int countRangeSum(int[] nums, int lower, int upper) {

        if (nums.length ==0 || lower > upper){
            return 0;
        }


        int r = nums.length-1;
        int ans = calculate(nums,0,r,lower,upper);

        return  ans;
    }

    public static int calculate(int[] nums,int l,int r,int lower,int upper){
        if (l==r){
            return (nums[l] >= lower && nums[l] <= upper)? 1 : 0;
        } else if (l<r){
            int m = l+(r-l)/2;
            long[] prefixOfSecondArray = new long[r-m+1];
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
                int tempupper = binarySearch(prefixOfSecondArray, upper-sum);
                int templower = binarySearch(prefixOfSecondArray, lower-sum);
                if ( tempupper==-1 || templower==nums.length){
                    continue;
                } else{
                    count += (tempupper- templower) +1;
                }
            }
            return calculate(nums,l,m,lower,upper) + calculate(nums,m+1,r,lower,upper) + count;

        }else {
            return 0;
        }

    }

    public static int binarySearch(long[] nums,long val){
        int left=0,right=nums.length-1;
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
        if (left ==0 && nums[0] > val) return -1;
        return left;

    }

//    private int[] ans;

    public static void main(String[] args){
        int[] arr = {-2,5,-1};
//        System.out.println(binarySearch(arr,-2));
//                System.out.println(binarySearch(arr,1000));
        System.out.println(countRangeSum(arr,-2,2));
    }
}
