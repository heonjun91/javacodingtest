package Programmers.LevelOne;
//다트게임

import java.util.Arrays;
import java.util.Stack;

public class DartGame {
    public static void main(String[] args){
        String dartResult ="1D2S#10S";

        DartGame dg = new DartGame();
        System.out.println(dg.solve(dartResult));
    }

    public int solve(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        boolean num10 = false;
        while(idx<dartResult.length()){
            char c = dartResult.charAt(idx);
            if(Operator(c)==0){
                if(num10==true){
                    stack.push(stack.pop()*10+(Integer.parseInt(c+"")));
                    num10= false;
                }
                else {
                    stack.push(Integer.parseInt(c+""));
                    num10 = true;
                }
            }
            else if(Operator(c)==1){
                if(c=='S'){
                    stack.push((int)Math.pow(stack.pop(),1));
                }
                if(c=='D'){
                    stack.push((int)Math.pow(stack.pop(),2));
                }
                if(c=='T'){
                    stack.push((int)Math.pow(stack.pop(),3));
                }
                num10 = false;
            }
            else{
                if(c=='*'){
                    int temp = stack.pop()*2;

                    if(!stack.isEmpty()){
                        int temp2 = stack.pop()*2;
                        stack.push(temp2);
                        stack.push(temp);
                    }
                    else{
                        stack.push(temp);
                    }
                }
                else{
                    stack.push(stack.pop()*(-1));
                }
                num10 = false;
            }

            idx++;
        }
        int answer = 0;
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            answer += stack.pop();
        }
      return answer;
    }
    public int Operator(char c){
        if(c=='D'||c=='S'||c=='T')
            return 1;
        if(c=='*'||c=='#')
            return 2;
        return 0;
    }
}
