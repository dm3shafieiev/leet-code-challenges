package com.company;

import java.util.Stack;

public class MinStackV2 {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStackV2() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    if(stack.isEmpty()) {
      stack.push(val);
      minStack.push(val);
      return;
    }

    stack.push(val);

    if(minStack.peek() >= val) {
      minStack.push(val);
    }
  }

  public void pop() {
    int val = stack.pop();
    if(minStack.peek() == val) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
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