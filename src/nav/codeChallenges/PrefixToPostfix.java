package nav.codeChallenges;

import java.util.Scanner;

class StackObj{
    private int top, MAX;
    private String a[] = new String [1000];
    public StackObj(){
        top = -1;
        MAX = 1000;
        a[0] = "";
    }
    public void push(String x){
        if (top <= MAX-1){
            a[++top] = x;
        }
        else{
            System.out.println("Stack overflow");
        }
    };
    public String pop(){
        if (top == -1){
            System.out.println("\nStack empty!");
            return "\n";
        }
        else{
            return a[top--];
        }
    };
    public int getTop(){
        return top;
    };
}

public class PrefixToPostfix {
    static boolean isOperator (char ch){
        switch (ch){
            case '+':
            case '-':
            case '*':
            case '/':
            case '$':
                        return true;
            default :
                        return false;
        }
    }
    public static void main(String[] args) {
        //declarations
        Scanner in = new Scanner (System.in);
        String exp;
        int i;
        String[] strArr = {"*34", "+1*23", "+12"};
        String[] postFixArr = new String[strArr.length];
        int index = 0;
        for(String str : strArr) {
	        StackObj s = new StackObj ();
	        exp = str;
	        String exp_str[] = new String[exp.length()];
	        String postfix_exp = "\n";	        
	
	        //create a string array of all characters but in reverse
	        for(i=0; i<=exp.length()-1; i++){
	            exp_str[exp.length()-1-i]=Character.toString(exp.charAt(i));
	        }
	
	        //computing postfix:
	        i=0;
	        do{ 
	            if (!isOperator(exp_str[i].charAt(0)))
	                s.push(exp_str[i]);
	            else{
	                String str1 = s.pop();
	                String str2 = s.pop();
	                str1 = str1 + str2 + exp_str[i];
	                postfix_exp = str1;
	                s.push(str1);
	            }
	            i++;
	        }while(s.getTop()>=0 && i!=exp.length());
	        postFixArr[index++] = postfix_exp;	      
        }
        //Output
        System.out.println("After converting to postfix : " );
        for(String s : postFixArr)
        	System.out.println(s);
        in.close();
    }
}