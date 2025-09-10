class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(s.length()<p.length()){
            return ans;
        }
        HashMap<Character,Integer> pMap=new HashMap<>();
        HashMap<Character,Integer> sMap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char chP=p.charAt(i);
            char chS=s.charAt(i);
            pMap.put(chP,pMap.getOrDefault(chP,0)+1);
            sMap.put(chS,sMap.getOrDefault(chS,0)+1);
        }
        if(pMap.equals(sMap))
            ans.add(0);
        for(int i=0;i<s.length()-p.length();i++){
            char remChar=s.charAt(i);
            char addChar=s.charAt(i+p.length());
            sMap.put(remChar,sMap.get(remChar)-1);
            if(sMap.get(remChar)==0){
                sMap.remove(remChar);
            }
            sMap.put(addChar,sMap.getOrDefault(addChar,0)+1);
            if(pMap.equals(sMap))
            ans.add(i+1);
        }
        return ans;
    }
}