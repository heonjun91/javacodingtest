package QueueAndStack;
//배열이 주어지고 배열안의 모든 값을 ouput으로 내는 문제이다. 하지만 특수한 경우들이있다.

//1. "+" 문자가 있는경우 전 두값을 더한 값을

//2. "D" 문자가 있는경우 전 값의 두배를

//3. "C" 문자가 있는경우 전 값을 삭제
//Input: ["5","2","C","D","+"] Output: 30
//Input: ["5","-2","4","C","D","9","+","+"] Output: 27

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args){
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        String[] strs2 = {"5","2","C","D","+"};


        BaseballGame bg = new BaseballGame();
        bg.solve(strs);
        bg.solve(strs2);
    }

    public void solve(String[] strs) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< strs.length; i++){
            String str = strs[i];
            if(str.equals("C")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(str.equals("D")){
                if(!stack.isEmpty()){
                    int n = stack.peek();
                    stack.add(2*n);
                }
            }
            else if(str.equals("+")){
                if(stack.size()>=2){
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    int n3 = n1+n2;
                    stack.add(n1);
                    stack.add(n2);
                    stack.add(n3);
                }
            }
            else {
                int n = Integer.parseInt(str);
                stack.add(n);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}
