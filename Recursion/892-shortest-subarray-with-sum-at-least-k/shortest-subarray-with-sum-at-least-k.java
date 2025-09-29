class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long prefixSum[]=new long[n];
        long sum=0;
        long target=(long)k;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefixSum[i]=sum;
        }
        Deque<Integer> queue=new ArrayDeque<>();
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prefixSum[i]>=target){
                minLen=Math.min(minLen,i+1);
            }

            //Shrink queue if sum is greater than target
            while(!queue.isEmpty() && prefixSum[i]-prefixSum[queue.peek()]>=target){
                minLen=Math.min(minLen,i-queue.peekFirst());
                queue.poll();
            }

            //removing unwanted indices
            while(!queue.isEmpty() && prefixSum[i]<prefixSum[queue.peekLast()]){  
                queue.pollLast();
            }
            queue.offer(i);
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
        
    }
}