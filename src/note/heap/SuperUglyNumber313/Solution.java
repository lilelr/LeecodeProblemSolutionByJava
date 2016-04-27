package note.heap.SuperUglyNumber313;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yuxiao on 4/27/16.
 */
public class Solution {
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

    @Test
    public void testnthUglyNumber(){
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(10,primes));
//        System.out.println(nthSuperUglyNumber(6,primes));
//        System.out.println(nthSuperUglyNumber(7,primes));
//        System.out.println(nthSuperUglyNumber(9,primes));
    }

}
