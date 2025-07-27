class Solution {
    public int findMin(int[] nums) {
        // int low=0;
        // int n=nums.length-1;
        // int high=nums.length-1;
        // int mid;
        // int min=nums[0];
        // if(n==0){
        //     return nums[0];
        // }
        // if(n==1){
        //     return Integer.min(nums[0],nums[1]);
        // }
        // while(low<=high){
        //     mid=low+(high-low)/2;
        //     if(mid>0 && mid<n){
        //         if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
        //             return nums[mid];
        //         }
        //         else if(nums[mid]>nums[mid+1]){
        //             low=mid+1;
        //         }
        //         else{
        //             high=mid-1;
        //         }
        //     }
        //     else{
        //         if(mid==0){
        //             if(nums[mid]<nums[n] && nums[mid]>nums[mid+1]){
        //                 return nums[mid];
        //             }
        //             else{
        //                 low=mid+1;
        //             }
        //         }
        //         else if(mid==n){
        //             if(nums[mid]<nums[mid-1] && nums[mid]>nums[0]){
        //                 return nums[mid];
        //             }
        //             else{
        //                 high=mid-1;
        //             }
        //         }
        //     }
        // }
        // return nums[low];
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}