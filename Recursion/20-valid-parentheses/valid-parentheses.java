class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Character> charMap=new HashMap<>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!stack.empty() && stack.peek()==charMap.get(ch)){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        if(stack.empty())
        return true;
        else
        return false;
    }
}