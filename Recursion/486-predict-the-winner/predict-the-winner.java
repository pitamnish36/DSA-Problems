class Solution {
    public boolean predictTheWinner(int[] nums) {
        int res=predict(nums,0,nums.length-1,0);
        return res>=0;
    }
    public int predict(int []nums,int left,int right,int turn){
        if(left==right){
            return nums[left];
        }

        int ans=0;
        if(turn%2==0){
            int first=nums[left]+predict(nums,left+1,right,turn+1);
            int second=nums[right]+predict(nums,left,right-1,turn+1);
            ans=Integer.max(first,second);
        }
        else{
            int first=-nums[left]+predict(nums,left+1,right,turn+1);
            int second=-nums[right]+predict(nums,left,right-1,turn+1);
            ans=Integer.min(first,second);
        }
        return ans;
    }
}