class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        while(right<n){
            sum+=nums[right];
    
            while(sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}