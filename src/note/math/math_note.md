Bitwise AND of Numbers Range 201
位运算: &
 1. a >> t << t 让a(二进制)的后边t位为0
 2. 当程序需要乘2的多少次方时,可考虑<<1,2
 3. 想知道一个二进制数共有多少位,考虑用log运算
    位数= log(n)/log2

Count Primes 204
计算质数, O(n(logn)(lognlogn))
 // j = i*i+n*i = i*(i+n) ,so j is not prime

Happy Number 202
   用list的contain方法判断是否包含重复元素
   if(record.contains(n)) {
         return false;
   }

Rectangle Area 223
分情况讨论,多多考虑极端情况,如点相同



