class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipList=new ArrayList<>();
        List<String> ip=new ArrayList<>();
        if(s.length()>=4 && s.length()<=12){
            generate(s,0,ip,ipList);
            return ipList;
        }
        else{
            return new ArrayList<String>();
        }
    }
    public void generate(String s,int idx,List<String> ip,List<String> ipList){
        if(ip.size()==4){
            if(idx==s.length()){
                ipList.add(String.join(".",ip));
            }
        }
        else{
            for(int i=idx+1;i<=idx+3 && i<=s.length();i++){
                String nextInt=s.substring(idx,i);
                if(Integer.valueOf(nextInt)<=255 && (nextInt.equals("0") || nextInt.charAt(0)!='0')){
                    ip.add(nextInt);
                    generate(s,i,ip,ipList);
                    ip.remove(ip.size()-1);
                }
            }
        }
    }
}