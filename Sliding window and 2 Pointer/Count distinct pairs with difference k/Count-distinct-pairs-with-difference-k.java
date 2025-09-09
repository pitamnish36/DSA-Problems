class Solution {
    //Hashmap Approach
    public int TotalPairs(int[] nums, int k) {
        // Code here
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num:map.keySet()){
            if(k==0 && map.get(num)>1){
                cnt++;
            }
            else if(k>0 && map.containsKey(num+k)){
                cnt++;
            }
        }
        return cnt;
    }

    //Two pointer approach
    public int TotalPairs(int[] nums, int k) {
        // Code here
        Arrays.sort(nums);
        HashSet<String> uniqueSet=new HashSet<>();
        int left=0;
        int right=1;
        while(right<nums.length){
            if(left==right){
                right++;
                continue;
            }
            int diff=nums[right]-nums[left];
            if(diff==k){
                uniqueSet.add(nums[right]+":"+nums[left]);
                left++;
                right++;
            }
            else if(diff<k){
                right++;
            }
            else{
                left++;
            }
        }
        return uniqueSet.size();
    }


}