class Solution {
    public boolean isAnagram(String s, String t) {
        char [] sArr=s.toCharArray();
        char [] tArr=t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        s=new String(sArr);
        t=new String(tArr);
        return t.equals(s);
    }
}