package note.heap.SuperUglyNumber313;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/27/16.
 * https://leetcode.com/problems/super-ugly-number/
 */
public class Solution {
        //https://leetcode.com/discuss/81411/java-three-methods-23ms-58ms-with-heap-performance-explained
    //62 ms O(nlogk)
    public int nthSuperUglyNumberHeap(int n, int[] primes) {
       int[] ugly = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0;i<primes.length;i++) pq.add(new Num(primes[i],1,primes[i]));
        ugly[0] = 1;

        for(int i=1;i<n;i++){
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]){
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p*ugly[nxt.idx],nxt.idx+1,nxt.p));
            }
        }

        return ugly[n-1];
    }


    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val,int idx,int p){
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }

    //solution 2   31ms get faster performance for custom heap because PriorityQueue includes higher level object.
    public int nthSuperUglyNumberByCustomHeap(int n, int[] primes){
        int[] index = new int[1000];
        int[] res = new int[n];
        int[] heap = new int[primes.length];
        for(int i = 0;i<primes.length; i++)heap[i] = primes[i];
        res[0] = 1;
        for(int i = 1; i<n;)
        {
            if(res[i-1] != heap[0]){
                res[i] = heap[0];
                System.out.print(res[i]+" ");
                i++;
            }
            updateHeap(heap,primes,index,res);
        }
        return res[n-1];
    }
    public void heapify(int[] heap, int[] primes, int i){
        int index = i;
        int left = 2*i+1; int right = left+1;
        if(heap.length>left && heap[i] > heap[left]) index = left;
        if(heap.length>right && heap[index] > heap[right]) index = right;
        if(i!=index){
            int temp = heap[i];
            heap[i] = heap[index];
            heap[index] = temp;
            int tempPri = primes[i];
            primes[i] = primes[index];
            primes[index] = tempPri;
            heapify(heap,primes,index);
        }
    }
    public void updateHeap(int[] heap, int[] primes, int[] index, int[] res)
    {
        index[primes[0]]++;
        heap[0] = res[index[primes[0]]] * primes[0];
        heapify(heap,primes,0);
    }

    @Test
    public void testnthUglyNumber(){
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumberHeap(10, primes));
//        System.out.println(nthSuperUglyNumber(6,primes));
//        System.out.println(nthSuperUglyNumber(7,primes));
//        System.out.println(nthSuperUglyNumber(9,primes));
    }

}
