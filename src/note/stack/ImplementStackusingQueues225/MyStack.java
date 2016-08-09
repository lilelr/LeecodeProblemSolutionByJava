package note.stack.ImplementStackusingQueues225;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by yuxiao on 8/9/16.
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    private  Deque<Integer> deque = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        deque.offerLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        deque.pollLast();
    }

    // Get the top element.
    public int top() {
        return deque.getLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return deque.isEmpty();
    }

    @Test
    public void test(){
        push(1);
       push(2);
//        int res =top();
//        pop();
//        res = top();
        pop();
        boolean isEmpty = empty();
    }
}
