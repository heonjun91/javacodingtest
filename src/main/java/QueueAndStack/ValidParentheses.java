package QueueAndStack;

import java.util.HashMap;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args){

        String exp = "({})[]";

        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.solve(exp));
    }

    public boolean solve(String exp) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');


        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);

            if(map.containsValue(c)){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(stack.peek()==map.get(c)){
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
