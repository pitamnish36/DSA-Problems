class Solution {
    public int majorityElement(int[] nums) {
        int major=nums[0];
        int votes=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==major){
                votes++;
            }
            else{
                votes--;
                if(votes==0){
                    major=nums[i];
                    votes++;
                }
            }
        }
        return major;
    }
}