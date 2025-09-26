class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int result[]=new int[n-k+1];
        int counter=0;
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!queue.isEmpty() && queue.peek()<i-k+1){
                queue.poll();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offer(i);

            if(i>=k-1){
                result[counter++]=nums[queue.peek()];
            }

        }
        return result;
    }
}