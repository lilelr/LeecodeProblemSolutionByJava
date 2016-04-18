package problems.CountPrimes204;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yuxiao on 16/4/18.
 * https://leetcode.com/problems/count-primes/
 */
public class Solution {

    public boolean isPrimes(List<Integer> primesList,int m){
        int len = primesList.size();
        for(int i=0;i <len;i++){
            if(m%primesList.get(i)==0){
                return false;
            } else if(primesList.get(i)*primesList.get(i) > m){
                return true;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        if(n==0 || n==1) return 0;
        if(n==2) return 0;
        if(n==3) return 1;
        if(n==4) return 2;

        List<Integer> primesList = new ArrayList<>();
        primesList.add(2);
        primesList.add(3);
        int sum=2;
        for(int i=5;i<n;i++){
            if(isPrimes(primesList,i)){
                sum++;
                primesList.add(i);
            }
        }

        return sum;
    }

    // O(nloglogn)
    public int countPrimesBest(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(countPrimes(129));
        System.out.println(countPrimes(5));
    }

}
