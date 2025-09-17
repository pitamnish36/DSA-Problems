class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        Stack<Integer> stack=new Stack<>();
        for(int stone:stones){
            stack.push(stone);
        }
        int stone1=0;
        while(!stack.isEmpty()){
            stone1=stack.pop();
            if(stack.isEmpty()){
                return stone1;
            }
            int stone2=stack.pop();
            if(stone1!=stone2){
                insert(stack,stone1-stone2);
            }
        }
        return 0;
    }
    public void insert(Stack<Integer> stack,int el){
        Stack<Integer> temp=new Stack<>();
        int num=0;
        while(!stack.isEmpty()){
            if(el>stack.peek()){
                stack.push(el);
                break;
            }
            temp.push(stack.pop());
        }
        if(stack.isEmpty()){
            stack.push(el);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}