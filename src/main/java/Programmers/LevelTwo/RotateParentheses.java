package Programmers.LevelTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//괄호 회전하기
public class RotateParentheses {

    public static void main(String[] args){
        String s = "{{{";
        RotateParentheses rp = new RotateParentheses();
        System.out.println(rp.solution(s));
    }

    public int solution(String s) {
        int answer = 0;
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        for(int i=0; i<s.length(); i++){
            String temp = s.substring(i)+s.substring(0,i);

            if(correct(temp,map)){
                answer++;
            }
        }

        return answer;
    }
    public boolean correct(String s,Map<Character,Character> map){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(!map.containsKey(a)){
                stack.push(a);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if(stack.peek()!=map.get(a))
                        return false;
                    else
                        stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
