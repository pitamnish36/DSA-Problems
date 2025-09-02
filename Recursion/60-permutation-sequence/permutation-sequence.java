class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> remNum=new ArrayList<>();
        int fact=1;
        for(int i=0;i<n;i++){
            remNum.add(i+1);
            fact*=(i+1);
        }
        StringBuilder ans=new StringBuilder();
        k=k-1;
        for(int i=0;i<n;i++){
            fact/=(n-i);
            int fixNum=k/fact;
            ans.append(remNum.get(fixNum));
            k-=fact*(fixNum);
            remNum.remove(fixNum);
        }
        //ans.append(remNum.get(0));
        return ans.toString();
    }
}