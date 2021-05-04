package Programmers.LevelTwo;
//[카카오] 괄호변환

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesConversion {
    public static void main(String[] args) {
        String p =")(";

        ParenthesesConversion pc = new ParenthesesConversion();
        System.out.println(pc.solve(p));
    }

    public String solve(String p) {
        String answer = "";

        if(p.equals(""))
            return p;

        String u = p.substring(0,balance(p));
        String v = p.substring(balance(p));

        if(correct(u)){
            return u+solve(v);
        }
        else{
            answer += "("+solve(v)+")";
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i)=='(')
                    answer+=")";
                else
                    answer+="(";
            }
            return answer;
        }
    }

    public int balance(String p){
        int cnt = 0;
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);

            if(c=='('){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt==0)
                return i+1;
        }
        return 0;
    }
    public boolean correct(String p){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return true;
    }
}
