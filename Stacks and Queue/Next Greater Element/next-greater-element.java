class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stack =new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            int el=searchGreater(stack,arr[i]);
            ans.add(el);
        }
        Collections.reverse(ans);
        return ans;
    }
    public int searchGreater(Stack<Integer> stack,int el){
        Stack<Integer> temp=new Stack<>();
        int greaterEl=-1;
        while(!stack.isEmpty()){
            if(stack.peek().intValue()>el){
                greaterEl=stack.peek();
                break;
            }
            stack.pop();
        }
        stack.push(el);
        return greaterEl;
    }
}
