import java.util.*;

public class BracketChallenge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();
        int p=sc.nextInt();
        Stack<String> stack=new Stack<>();
        List<String> brackets=new ArrayList<>();
        generate("",brackets,b,b,p,p,stack);
    }

    public static void generate(String str,List<String> list,int Ob,int Cb,int Op,int Cp,Stack<String> stack){
        if(Ob==0 && Cb==0 && Op==0 && Cp==0){
            System.out.println(str);
            return;
        }

        if(Ob!=0){
            stack.push("(");
            generate(str+"(",list,Ob-1,Cb,Op,Cp,stack);
            stack.pop();
        }
        if(Cb>Ob && !stack.isEmpty() && stack.peek()=="("){
            stack.pop();
            generate(str+")",list,Ob,Cb-1,Op,Cp,stack);
            stack.push("(");
        }
        if(Op!=0){
            stack.push("{");
            generate(str+"{",list,Ob,Cb,Op-1,Cp,stack);
            stack.pop();
        }
        if(Cp>Op && !stack.isEmpty() && stack.peek()=="{"){
            stack.pop();
            generate(str+"}",list,Ob,Cb,Op,Cp-1,stack);
            stack.push("{");
        }

    }
}