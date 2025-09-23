class Solution {
    public String removeDuplicateLetters(String s) {
        int []lastIndex=new int[26];

        for(int index=0;index<s.length();index++){
            lastIndex[s.charAt(index)-'a']=index;
        }

        boolean seen[]=new boolean[26];
        Stack<Character> ans=new Stack<>();

        for(int index=0;index<s.length();index++){
            char currentChar=s.charAt(index);
            if(seen[currentChar-'a'])
            continue;

            while(!ans.isEmpty() && currentChar<ans.peek() && lastIndex[ans.peek()-'a']>index){
                seen[ans.pop()-'a']=false;
            }

            ans.push(currentChar);
            seen[currentChar-'a']=true;
        }

        StringBuilder result=new StringBuilder();
        while(!ans.isEmpty()){
            result.append(ans.pop());
        }
        return result.reverse().toString();
    }
}