class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int []nums,int k){
        int left=0;
        int right=0;
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k && left<=right){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
}