package note.sort.LargetstNumber179;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yuxiao on 16/6/2.
 * https://leetcode.com/problems/largest-number/
 */
public class Solution {
    public String largestNumber(int[] nums) {
        MyStrItem[] ansItems = new MyStrItem[nums.length];
        for (int i = 0; i < nums.length; i++) {
            MyStrItem tMyStrItem = new MyStrItem(nums[i] + "");
            ansItems[i] = tMyStrItem;
        }
        Arrays.sort(ansItems, new ComparatorMyStrItem());
        String res = "";
        for (int i = 0; i < ansItems.length; i++) {
            MyStrItem myStrItem = ansItems[i];
//            System.out.println(myStrItem.getStr());
            res += myStrItem.getStr();
        }
        if (res.length() > 0 && res.charAt(0) == '0') return "0";
        return res;
    }

    public class MyStrItem {

        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public MyStrItem(String s) {
            str = s;
        }
    }

    public class ComparatorMyStrItem implements Comparator {


        @Override
        public int compare(Object o1, Object o2) {
            MyStrItem myStrItem1 = (MyStrItem) o1;
            MyStrItem myStrItem2 = (MyStrItem) o2;
            int len1 = myStrItem1.getStr().length();
            int len2 = myStrItem2.getStr().length();
            if (len1 == len2) {
                for (int i = 0; i < len1; i++) {
                    if (myStrItem1.getStr().charAt(i) > myStrItem2.getStr().charAt(i)) {
                        return -1;
                    } else if (myStrItem1.getStr().charAt(i) < myStrItem2.getStr().charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            } else {
                int minLen = Math.min(len1, len2);

                for (int i = 0; i < minLen; i++) {
                    if (myStrItem1.getStr().charAt(i) > myStrItem2.getStr().charAt(i)) {
                        return -1;
                    } else if (myStrItem1.getStr().charAt(i) < myStrItem2.getStr().charAt(i)) {
                        int b;
                        return 1;
                    }
                }

                if (minLen == len1) {
                    for (int i = minLen; i < len2; i++) {
                        char tempItemOfLongStr = myStrItem2.getStr().charAt(i);
                        for (int j = 0; j < len1; j++) {
                            if (tempItemOfLongStr > myStrItem1.getStr().charAt(j)) {
                                return 1;
                            } else if (tempItemOfLongStr < myStrItem1.getStr().charAt(j)) {
                                return -1;
                            }
                        }
                    }
                    return 0;
                } else {
                    for (int i = minLen; i < len1; i++) {
                        char tempItemOfLongStr = myStrItem1.getStr().charAt(i);
                        for (int j = 0; j < len2; j++) {
                            if (tempItemOfLongStr > myStrItem2.getStr().charAt(j)) {
                                return -1;
                            } else if (tempItemOfLongStr < myStrItem2.getStr().charAt(j)) {
                                return 1;
                            }
                        }
                    }
                    return 0;
                }
            }

        }
    }

    @Test
    public void test() {
//        int[] nums = {34,30,9,5,3};
        int[] nums = {8247, 824};
        String res = largestNumber(nums);
        System.out.println(res);

//        MyStrItem myStrItem1 = new MyStrItem("30");
//        MyStrItem myStrItem2 = new MyStrItem("34");
//        MyStrItem[] testItems = {myStrItem1,myStrItem2};
//        Arrays.sort(testItems,new ComparatorMyStrItem());
//        System.out.println(testItems[0].getStr());
    }


}
