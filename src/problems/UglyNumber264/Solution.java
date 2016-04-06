package problems.UglyNumber264;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 4/6/16.
 */
public class Solution {

    private  List<Integer> numList = new ArrayList<>();

    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        int numsize = numList.size();
        if(numsize>=n){
            return numList.get(n-1);
        }


        int pos=2;
        while (numsize<n){

            int[] temparr = new int[9];
            int temppos=0;
            for(int i=0;i<3;i++){
                temparr[temppos++]=(this.numList.get(pos+i)*2);
                temparr[temppos++]=(this.numList.get(pos+i)*3);
                temparr[temppos++]=(this.numList.get(pos+i)*5);
            }

            Arrays.sort(temparr);
            for(int i=0;i<9;i++){
                if (this.numList.contains(temparr[i])) continue;
                this.numList.add(temparr[i]);
            }
            numsize = numList.size();
            pos += 1;
        }

        return numList.get(n-1);

//        int pos=1;
//        int limit = n+30;
//        while (numsize<limit){
//            merge(pos,numList.get(pos));
//            pos++;
//            numsize = numList.size();
//        }
//
//        return numList.get(n-1);




    }




    private void merge(int pos,int posItem){
        int[] temparr = {posItem*2,posItem*3,posItem*5};
        for(int i=0;i<3;i++){
            int temp = temparr[i];
            if(this.numList.contains(temp)) continue;

            int len = this.numList.size();
            boolean flag = false;
            for(int j=pos+1;j<len;j++){

                 if(this.numList.get(j) > temp){
                    flag = true;
                    this.numList.add(j,temp);
                     break;
                }
            }
            if(!flag){
                this.numList.add(temp);
            }
        }
    }


    @Test
    public void testnthUglyNumber(){
        System.out.println(nthUglyNumber(12));
    }
}
