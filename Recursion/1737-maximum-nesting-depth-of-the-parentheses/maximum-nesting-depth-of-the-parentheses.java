class Solution {
    public int maxDepth(String s) {
        int max=0;
        int cursum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cursum+=1;
                if(max<cursum){
                    max=cursum;
                }
            }
            if(s.charAt(i)==')'){
                cursum-=1;
            }
        }
        return max;
    }
}