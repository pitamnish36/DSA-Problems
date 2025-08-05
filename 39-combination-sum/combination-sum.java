class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        generateCombinations(candidates,0,target,0,list,combinations);
        return combinations;
    }

    public void generateCombinations(int[] candidates,int st,int target,int sum,List<Integer> list,List<List<Integer>> combinations){
        if(sum==target){
            combinations.add(List.copyOf(list));
            return;
        }
        else if(sum>target){
            return;
        }
        int temp=sum;
        for(int i=st;i<candidates.length;i++){
            temp=candidates[i];
            list.add(temp);
            generateCombinations(candidates,i,target,sum+temp,list,combinations);
            list.remove(list.size()-1);
            //list.add(temp);
            //generateCombinations(candidates,i+1,target,sum+temp,list,combinations);
            //list.remove(list.size()-1);
            //temp=candidates[i]
            //genarateCombinations(candidates,i+1,target,sum+candidates[i],list,combinations);

        }
    }
}