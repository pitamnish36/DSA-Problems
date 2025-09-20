class Solution {
    public int sumSubarrayMins(int[] arr) {
        long modulo=100_000_0007;
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
            left[i]=-1;
            else
            left[i]=stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
            right[i]=n;
            else
            right[i]=stack.peek();
            stack.push(i);
        }
        long min=0;
        for(int i=0;i<n;i++){
            long subarr=((i-left[i])*(right[i]-i))%modulo;
            long sum=(arr[i]*subarr)%modulo;
            min=(min+sum)%modulo;
        }
        return (int)min;
    }
}