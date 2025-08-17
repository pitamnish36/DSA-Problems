class Solution {
    public void nextPermutation(int[] nums) {
        //find the peek element
        //find smallest element greater than peek element
        //swap both
        //reverse subarray in right of peek element

        //permuations are making a pattern like a group of permutations grouped by starting elements
        //we need to make changes after these group elements i.e peek element
        //because elements after that are already in their highest permutation order
        //reversing those elements will convert it into lowest permutation order
        //Since we need the immediate nex permutation will swap peek element with next greater element that it
        int peek=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                peek=i-1;
                break;
            }
        }
        if(peek==-1 ||  nums.length<=2){
            reverse(nums,0,nums.length-1);
            return;
        }
        int swapEl=peek+1;
        for(int i=peek+1;i<nums.length;i++){
            if(nums[i]>nums[peek] && nums[i]<=nums[swapEl]){
                swapEl=i;
            }
        }
        int temp=nums[swapEl];
        nums[swapEl]=nums[peek];
        nums[peek]=temp;
        reverse(nums,peek+1,nums.length-1);
    }

    public void reverse(int nums[],int start,int end){
        int mid=start+(end-start)/2;
        int n=end;
        int temp;
        if(end-start<2){
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            return;
        }
        for(int i=start;i<=mid;i++){
            System.out.println(nums[i]);
            temp=nums[i];
            nums[i]=nums[n-(i-start)];
            nums[n-(i-start)]=temp;
        }      
    }
}