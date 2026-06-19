class Solution {
    public int firstUniqChar(String s) {
        Character ch=s.chars().mapToObj(c->(char)c).filter(x->s.indexOf(x)==s.lastIndexOf(x)).findFirst().orElse('1');
        
        return ch=='1'?-1:s.indexOf(ch);
    }
}