class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        Map<Character,Integer> sortedMap=map.entrySet()
        .stream()
        .sorted(Map.Entry.<Character,Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1,e2)->e2,
            LinkedHashMap::new
        ));

        String res="";
        for(Map.Entry<Character,Integer> entry:sortedMap.entrySet()){
            res+=String.valueOf(entry.getKey()).repeat(entry.getValue());
        }
        return res;
    }
}