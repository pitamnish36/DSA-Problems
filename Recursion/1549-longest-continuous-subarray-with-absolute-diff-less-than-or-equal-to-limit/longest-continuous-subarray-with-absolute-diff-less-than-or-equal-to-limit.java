class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue=new ArrayDeque<>();
        Deque<Integer> maxQueue=new ArrayDeque<>();
        int left=0;
        int max=0;

        for(int right=0;right<nums.length;right++){
            while(!maxQueue.isEmpty() && maxQueue.peekLast()< nums[right]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);

            while(!minQueue.isEmpty() && minQueue.peekLast()>nums[right]){
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[right]);

            while(maxQueue.peekFirst()-minQueue.peekFirst()>limit){
                if(nums[left]==maxQueue.peekFirst())
                maxQueue.pollFirst();

                if(nums[left]==minQueue.peekFirst())
                minQueue.pollFirst();

                left++;
            }

            max=Math.max(max,right-left+1);
        }
        return max;
    }
}