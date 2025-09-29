class MinStack {
    public PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    public int top=-1;
    List<Integer> customStack;
    public MinStack() {
        customStack=new ArrayList<>();
    }
    
    public void push(int val) {
        customStack.add(val);
        minQueue.offer(val);
        top++;
    }
    
    public void pop() {
        int removed=customStack.remove(top);
        top--;
        minQueue.remove(removed);
    }
    
    public int top() {
        return customStack.get(top);
    }
    
    public int getMin() {
        return minQueue.peek();
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