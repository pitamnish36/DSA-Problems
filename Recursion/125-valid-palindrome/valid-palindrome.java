class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char p1=s.charAt(i);
            char p2=s.charAt(j);
            if(Character.isLetterOrDigit(p1) && Character.isLetterOrDigit(p2)){
                if(Character.toLowerCase(p1)!=(Character.toLowerCase(p2)))
                return false;
                i++;
                j--;
            }
            else{
                if(!Character.isLetterOrDigit(p1))
                i++;
                if(!Character.isLetterOrDigit(p2))
                j--;
            }
        }
        return true;
    }
}