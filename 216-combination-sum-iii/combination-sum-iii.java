class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> internal=new ArrayList<>();
        backtrackSum(1,k,0,n,internal,list);
        return list;
    }
    public static void backtrackSum(int st,int k,int sum,int n,List<Integer> internal,List<List<Integer>> list){
        if(sum>n){
            return;
        }
        if(k==0){
            if(sum==n)
            list.add(List.copyOf(internal));
            return;
        }
        for(int i=st;i<=9;i++){
            internal.add(i);
            backtrackSum(i+1,k-1,sum+i,n,internal,list);
            internal.remove(internal.get(internal.size()-1));
        }
    }
}