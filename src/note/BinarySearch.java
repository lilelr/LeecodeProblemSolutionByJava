package note;

import org.junit.Test;

/**
 * Created by yuxiao on 3/31/16.
 */
public class BinarySearch {

    /**
     *
     * @param nums  An array that has been sorted.
     * @param val   The input value to search for in the array.
     * @return      The position of the item whose value is great than or equal to the input value.
     *              If the input value is less than the smallest item of the array, return -1.
     *              If the input value is great then the biggest item of the array, return the length of the array.
     */
    public  int binarySearch(long[] nums,int val){
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
        return left;
    }

    /**
     *
     * @param nums  An array that has been sorted.
     * @param val   The double input value to search for in the array.
     * @return  The position of the item whose value is great than the input value.
     *          I modified the bounds to be "double" to avoid duplicate elements.
     *          For example, 3 is smaller than 3.5 by 0.5. If you search for 3.5,it will return the posion
     *          of the item whose value is great than 3.
     *
     */
    public  int binarySearchSecond(long[] nums, double val){
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


    /**
     *
     * @param nums An array that has been sorted.
     * @param val The double input value to search for in the array.
     * @return The position of the item whose value is less than or equal to the input value.
     */
    public int binarySearchThird(long[] nums, double val){
        int left=0,right=nums.length-1;
        int middle = 0;
        while(left <= right){
            middle = left + (right-left)/2;
            if(nums[middle] >= val){
                right = middle-1;
            } else{
                left = middle+1;
            }
        }
        return right;
    }

    @Test
    public void binarySearchTest(){
//        long[] arrtest = {-3,1,2,4};
        long[] arrtest = {-3};
        int pos1 = binarySearchThird(arrtest, -9);
        int pos2 = binarySearchThird(arrtest,5);
        System.out.println(pos1+":" + pos2);


    }


}
