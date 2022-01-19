import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    //要保证两个栈同进同出
    Stack<Integer> stack;
    Stack<Integer> monotoneDecStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.monotoneDecStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);

        int top = Integer.MIN_VALUE;
        if (this.monotoneDecStack.isEmpty()) {
            this.monotoneDecStack.push(val);
        } else {
            top = this.monotoneDecStack.peek();
            if (val < top) {
                this.monotoneDecStack.push(val);
            }else {
                this.monotoneDecStack.push(top);
            }
        }

    }

    public void pop() {
       this.stack.pop();
        this.monotoneDecStack.pop();
    
    }

    public int top() {
        return this.stack.peek();

    }

    public int getMin() {
        return this.monotoneDecStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
