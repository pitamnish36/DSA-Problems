class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> internal=new ArrayList<>();
        helper(1,n,k,internal,list);
        return list;
    }
    public static void helper(int st,int n,int k,List<Integer> internal,List<List<Integer>> list){
        if(k==0){
            list.add(List.copyOf(internal));
            return;
        }
        for(int i=st;i<=n;i++){
            internal.add(i);
            helper(i+1,n,k-1,internal,list);
            internal.remove(internal.size()-1);
        }

    }
}