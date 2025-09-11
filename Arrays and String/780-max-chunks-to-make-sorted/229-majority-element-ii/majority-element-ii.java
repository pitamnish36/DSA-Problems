class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n_3=nums.length/3;
        HashMap<Integer,Integer> digitCount=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            digitCount.put(nums[i],digitCount.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: digitCount.entrySet()){
            if(entry.getValue()>n_3){
                result.add(entry.getKey());
            }
        } 
        return result;
    }
}