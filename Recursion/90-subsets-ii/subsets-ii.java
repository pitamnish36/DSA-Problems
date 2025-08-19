class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,0,list,subset);
        return subset;
    }
    public void subset(int []nums,int st,List<Integer> list,List<List<Integer>> subset){
        //if(st==nums.length){
            subset.add(List.copyOf(list));
            //return;
        //}

        for(int i=st;i<nums.length;i++){
            if(i>st && nums[i]==nums[i-1])
            continue;
            //subset(nums,i+1,list,subset);
            list.add(nums[i]);
            subset(nums,i+1,list,subset);
            list.remove(list.size()-1);
        }
    }
}