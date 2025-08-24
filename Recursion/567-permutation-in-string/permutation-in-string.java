class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        return false;
        int []s1charCount=new int[26];
        Arrays.fill(s1charCount,0);
        int []s2charCount=new int[26];
        Arrays.fill(s2charCount,0);
        for(int i=0;i<s1.length();i++){
            int index1=s1.charAt(i)-'a';
            s1charCount[index1]=s1charCount[index1]+1;
            int index2=s2.charAt(i)-'a';
            s2charCount[index2]=s2charCount[index2]+1;
        }
        // System.out.println(Arrays.toString(s1charCount));
        // System.out.println(Arrays.toString(s2charCount));
        if(Arrays.equals(s1charCount,s2charCount))
        return true;
        if(s1.length()==s2.length())
        return false;
        for(int i=0;i<s2.length()-s1.length();i++){
            int j=i+s1.length();
            int index1=s2.charAt(j)-'a'; //enter
            int index2=s2.charAt(i)-'a'; //leaving
            s2charCount[index1]=s2charCount[index1]+1;
            s2charCount[index2]=s2charCount[index2]-1;
            //s2charCount[j]=s2charCount[j]+1;
            //s2charCount[i]=s2charCount[i]-1;
            // System.out.println(Arrays.toString(s1charCount));
            // System.out.println(Arrays.toString(s2charCount));
            // System.out.println("iteration");
            if(Arrays.equals(s1charCount,s2charCount))
            return true;
        }
        return false;
    }
}