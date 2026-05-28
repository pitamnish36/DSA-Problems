class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> sequenceList=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        if(s.length()<=10){
            return new ArrayList<>();
        }
        int st=0;
        for(int i=10;i<=s.length();i++){
            String sub=s.substring(st,i);
            if(map.containsKey(sub)){
                sequenceList.add(sub);
            }
            else{
                map.put(sub,1);
            }
            st++;
        }
        return List.copyOf(sequenceList);
    }
}