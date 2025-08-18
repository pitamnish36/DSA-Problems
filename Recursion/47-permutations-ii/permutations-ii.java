class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        generate(nums,list,permutations,new boolean[nums.length]);
        return permutations;
    }
    public void generate(int []nums,List<Integer> list,List<List<Integer>> ResultList,boolean[] used){
        if(list.size()==nums.length){
            ResultList.add(List.copyOf(list));
            //return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            else{
                used[i]=true;
                list.add(nums[i]);
                generate(nums,list,ResultList,used);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }
}