class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashMap<Character,Integer> track=new HashMap<>();
        int right=0;
        int left=0;
        for(right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(track.containsKey(c) && track.get(c)>=left){
                left=track.get(c)+1;
            }
            track.put(c,right);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}