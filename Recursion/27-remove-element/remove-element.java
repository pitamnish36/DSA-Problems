class Solution {
    public int removeElement(int[] nums, int val) {
        int imp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                int temp=nums[imp];
                nums[imp]=nums[i];
                nums[i]=temp;
                imp++;
            }
        }
        return imp;
    }
}