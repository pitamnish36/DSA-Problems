class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++){
            int l=i,r=i;
            String temp="" ;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(temp.equals("")){
                    temp+=s.charAt(l);
                }
                else{
                    temp=s.charAt(l)+temp+s.charAt(r);
                }
                l--;
                r++;
            }
            if(temp.length()>ans.length()){
                ans=temp;
            }
            temp="";
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                temp=s.charAt(l)+temp+s.charAt(r);
                l--;
                r++;
            }
            if(temp.length()>ans.length()){
                ans=temp;
            }
        }
        return ans;
    }
}