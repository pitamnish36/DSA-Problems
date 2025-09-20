class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        long modulo=100_000_0007;
        stack.push(-1);
        long ans=0;
        for(int i=0;i<=arr.length;i++){
            int curVal=(i==arr.length)?0:arr[i];
            while(stack.peek()!=-1 && curVal<=arr[stack.peek()]){
                int p=stack.pop();
                int j=stack.peek();
                int left=p-j;
                int right=i-p;
                long sum=(long)(left*right*(long)arr[p])%modulo;
                ans+=sum;
                ans=ans%modulo;
            }
            stack.push(i);
        }
        return (int)ans;
    }
}