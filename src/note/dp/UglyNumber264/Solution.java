package note.dp.UglyNumber264;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/6/16.
 */
public class Solution {



    /// Dynamic Programming  O(n)
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int i2=0,i3=0,i5=0;
        int count=1;
        while(count<=n){
            boolean flag=true;
            int nextItem = Math.min(ans.get(i2)*2,Math.min(ans.get(i3)*3,ans.get(i5)*5));
            if(nextItem == ans.get(i2)*2){
                i2++;
            }
            if(nextItem == ans.get(i3)*3){
                i3++;

            }
            if(nextItem == ans.get(i5)*5){
                i5++;

            }

                count++;
                ans.add(nextItem);


        }
        return ans.get(n-1);
    }

    //313 58ms  O(kN)
    public int nthSuperUglyNumber(int n, int[] primes) {

        if(n==1) return 1;
//        Queue<Long> queue = new PriorityQueue<>();
//        queue.offer(Long.valueOf(1));
//        Long pollItem = 0L;
//        for(int i=0;i<n;i++){
//            pollItem = queue.poll();
//            for(int factor:primes){
//                Long addItem = pollItem*factor;
//                if(!queue.contains(addItem)){
//                    queue.offer(addItem);
//                }
//            }
//        }
//        return pollItem.intValue();

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int[] statusPoints = new int[primes.length];
        int count=1;
        while (count<=n){
            int nextItem = Integer.MAX_VALUE;

            for(int i=0;i<statusPoints.length;i++){
                int compareItem = ans.get(statusPoints[i])*primes[i];
                if(compareItem < nextItem ){
                    nextItem = compareItem;
                }
            }

            for(int i=0;i<statusPoints.length;i++){
                if( ans.get(statusPoints[i])*primes[i] == nextItem){
                    statusPoints[i]++;
                }
            }
            count++;
            ans.add(nextItem);
        }

        return ans.get(n-1);
    }

    // optimize 31ms   O(kN)
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];

        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if (primes[j] * res[cur[j]] == res[i-1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }


    /// O(nlogk)  PriorityQueue
    public int uglyNumberByPriorityQueue(int n){
        if(n == 1) return 1;
        int[] factors = {2,3,5};
        Queue<Long> queue = new PriorityQueue<>();
        queue.offer(Long.valueOf(1));
        Long pollItem=0L;
        for (int i=0;i<n;i++){
             pollItem = queue.poll();
            for(int factor:factors){
                Long addItem = pollItem*factor;
                if(!queue.contains(addItem)){
                    queue.offer(addItem);
                }
            }
        }
        return pollItem.intValue();
    }



    @Test
    public void testnthUglyNumber(){

        System.out.println(uglyNumberByPriorityQueue(12));
    }
}
