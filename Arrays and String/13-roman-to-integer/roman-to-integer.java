class Solution {
    public int romanToInt(String s) {
        int i=0;
        int num=0;
        int n=s.length()-1;
        while(i<=n){
            char ch=s.charAt(i);
            if((i+1)<=n && ch=='I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                char sub=s.charAt(i+1);
                if(sub=='V')
                num+=4;
                else
                num+=9;
                i++;
            }
            else if((i+1)<=n && ch=='X' && (s.charAt(i+1)=='C' || s.charAt(i+1)=='L')){
                char sub=s.charAt(i+1);
                if(sub=='L')
                num+=40;
                else
                num+=90;
                i++;
            }
            else if((i+1)<=n && ch=='C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                char sub=s.charAt(i+1);
                if(sub=='D')
                num+=400;
                else
                num+=900;
                i++;
            }
            else{
                switch(ch){
                    case 'I':
                    num+=1;
                    break;

                    case 'V':
                    num+=5;
                    break;

                    case 'X':
                    num+=10;
                    break;

                    case 'L':
                    num+=50;
                    break;

                    case 'C':
                    num+=100;
                    break;

                    case 'D':
                    num+=500;
                    break;

                    case 'M':
                    num+=1000;
                    break;
                }
            }
            i++;
        }
        return num;
    }
}