class Solution {
    public boolean isAnagram(String s, String t) {
        int sArr[]=new int[26];
        int tArr[]=new int[26];
        if(s.length()!=t.length())
        return false;
        for(int i=0;i<t.length();i++){
            sArr[s.charAt(i)-'a']++;
            tArr[t.charAt(i)-'a']++;
        }
        if(Arrays.equals(sArr,tArr))
        return true;
        return false;
    }
}