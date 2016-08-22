package note.array.RangeSumQuery303;

/**
 * Created by yuxiao on 3/31/16.
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {


    public NumArray(int[] nums) {

        int len = nums.length;
        this.numsums = new long[len+1];
        for (int i=0;i<=len; i++){
            numsums[i] = 0;
        }
        long sum=0;
        numsums[0] = 0;
        for (int i=0;i<len;i++){
            sum += nums[i];
            numsums[i+1] = sum;
        }

    }

    public int sumRange(int i, int j) {
        return (int) (numsums[j + 1] - numsums[i]);
    }

    private long[] numsums;

}




// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);