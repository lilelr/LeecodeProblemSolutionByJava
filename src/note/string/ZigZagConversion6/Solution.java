package note.string.ZigZagConversion6;

import org.junit.Test;

/**
 * Created by yuxiao on 8/9/16.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s.isEmpty()) return s;
        int len = s.length();
        int intervalHeight = numRows - 2;
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int j = 0; j < numRows; j++) {
            sbs[j] = new StringBuffer();

        }
        boolean isEnd = false;
        int i = 0;
        while (i<len) {
            for (int j = 0; j < numRows; j++) {
                sbs[j].append(s.charAt(i ));
                i++;
                if (i >= len) {
                    isEnd = true;
                    break;
                }
            }

            if (isEnd) {
                break;
            } else {
                for (int k = numRows - 2; k >= 1; k--) {
                    sbs[k].append(s.charAt(i));
                    i++;
                    if (i >= len) {
                        isEnd = true;
                        break;
                    }
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for( int w=0;w<numRows;w++){
            res.append(sbs[w]);
        }
        return res.toString();
    }

    @Test
    public void test(){
//        String res = convert("PAYPALISHIRING", 3);
        String res = convert("PAGHNMUVXBNEKOGO", 4);
        System.out.println(res);
    }
}
