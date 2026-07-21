class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int curMax=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            curMax=Math.max(curMax,map.get(ch));
            while((i-left+1-curMax)>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(max,i+1-left);
        }
        return max;

    }
}