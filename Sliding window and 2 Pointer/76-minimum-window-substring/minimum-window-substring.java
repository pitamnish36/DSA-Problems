class Solution {
    public String minWindow(String s, String t) {
       if(s==null || t==null || s.length()<t.length())
       return "";

       int ans[]={-1,0,0};
       Map<Character,Integer> charMap=new HashMap<>();
       Map<Character,Integer> tMap=new HashMap<>();
       for(char ch:t.toCharArray()){
        tMap.put(ch,tMap.getOrDefault(ch,0)+1);
       }
       int formed=0;
       int required=tMap.size();
       int left=0;
       int right=0;
       for(right=0;right<s.length();right++){
        char rch=s.charAt(right);
        charMap.put(rch,charMap.getOrDefault(rch,0)+1);

        if(tMap.containsKey(rch) && charMap.get(rch).intValue()==tMap.get(rch).intValue()){
            formed++;
        }
        while(left<=right && formed==required){
            if(ans[0]==-1 || ans[0]>right-left+1){
                ans[0]=right-left+1;
                ans[1]=left;
                ans[2]=right;
            }

            char lch=s.charAt(left);
            charMap.put(lch,charMap.get(lch)-1);

            if(tMap.containsKey(lch) && charMap.get(lch).intValue()<tMap.get(lch).intValue()){
                formed--;
            }
            left++;
            
        }
        
       }
       return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }
}