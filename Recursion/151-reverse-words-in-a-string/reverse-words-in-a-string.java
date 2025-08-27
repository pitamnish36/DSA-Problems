class Solution {
    public String reverseWords(String s) {
        String str="";
        List<String> wordList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                str+=s.charAt(i);
            }
            else{
                if(str!=""){
                    wordList.add(str);
                    str="";
                }
                else{
                    continue;
                }
            }
        }
        if(str!="")
        wordList.add(str);
        Collections.reverse(wordList);
        System.out.println(wordList);
        String rev="";
        int i;
        for(i=0;i<wordList.size()-1;i++){
            rev+=wordList.get(i);
            rev+=" ";
        }
        rev+=wordList.get(i);
        return rev;
    }
}