class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int high=Arrays.stream(nums).max().getAsInt();
        int low=1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(isFeasible(nums,mid,maxOperations)){
               high=mid;
            }
            else{
               low=mid+1;
            }
        }
        return low;
    }
    public boolean isFeasible(int[] nums,int x,int maxOp){
        for(int i=0;i<nums.length;i++){
            if(nums[i]>x){
                maxOp-=(nums[i]-1)/x;
            }
            if(maxOp<0){
                return false;
            }
        }
        return true;
    }
}