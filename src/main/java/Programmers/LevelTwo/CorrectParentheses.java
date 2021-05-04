package Programmers.LevelTwo;

import java.util.Stack;

//올바른괄호
public class CorrectParentheses {
    public static void main(String[] args){
        String s = "()()";

        CorrectParentheses cp = new CorrectParentheses();
        System.out.println(cp.solution(s));
    }
    public boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    answer = false;

                else {
                    if(stack.peek() == '(')
                        stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            answer = false;

        return answer;
    }

}
