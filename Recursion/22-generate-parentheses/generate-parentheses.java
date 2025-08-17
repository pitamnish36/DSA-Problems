class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        helper(n,n,"",list);
        return list;
    }
    static void helper(int closed,int open,String res,List<String> list){
        if(closed==0 && open==0){
            list.add(res);
            return;
        }
        if(open>0)
        helper(closed,open-1,res+"(",list);
        if(closed>0 && (closed>open))
        helper(closed-1,open,res+")",list);
    }
}