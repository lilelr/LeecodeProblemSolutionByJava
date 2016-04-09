package problems.LRUCache146;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yuxiao on 4/9/16.
 */
public class LRUCache {

    private int mcapacity;
    private LinkedList<Integer> cacheNums;
    private HashMap<Integer,Integer> cacheMap;
    private int curSize;

    public LRUCache(int capacity) {
        this.mcapacity = capacity;
        this.cacheNums = new LinkedList<Integer>();
        this.cacheMap = new HashMap<>();
        this.curSize=0;
    }

    public int get(int key) {
        if(this.cacheNums.remove(Integer.valueOf(key))){
           this.cacheNums.push(Integer.valueOf(key));
            return this.cacheMap.get(Integer.valueOf(key));
        } else{
            return -1;
        }
    }

    public void set(int key, int value) {
        Integer keyCopy = Integer.valueOf(key);
        if(this.cacheNums.remove(keyCopy)){
            this.cacheNums.push(keyCopy);
            this.cacheMap.replace(keyCopy, value);
        } else{
            if(this.curSize < this.mcapacity){
                this.curSize++;
                this.cacheNums.push(keyCopy);
                this.cacheMap.put(keyCopy,value);
            } else{
                Integer remKey=this.cacheNums.removeLast();
                this.cacheNums.push(keyCopy);
                this.cacheMap.remove(remKey);
                this.cacheMap.put(keyCopy,value);
            }

        }
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1,-1);
        lruCache.set(3,-3);
        int tmpval = lruCache.get(3);
        lruCache.set(2,-2);
    }

    @Test
    public void testLRUCache(){
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1,-1);
        lruCache.set(3,-3);
        int tmpval = lruCache.get(3);
        lruCache.set(2,-2);

    }
}
