package DFSandBFS;
//*****************어려움

//열린 괄호 및 닫힌 괄호 및 선택적으로 일부 문자를 포함할 수 있는 식이 제공됩니다.
// 문자열에 다른 연산자는 없습니다.
// 입력 문자열을 유효하게 만들려면 최소 괄호 수를 제거해야 합니다.
// 둘 이상의 유효한 출력이 동일한 수의 괄호를 제거할 수 있는 경우 해당 출력을 모두 인쇄합니다.
//Example 1:
//Input: s = "()())()"
//Output: ["(())()","()()()"]

//Example 2:
//Input: s = "(a)())()"
//Output: ["(a())()","(a)()()"]

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main (String[] args){
        String str ="(a)())()";

        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        rip.solve(str);

    }
    public List<String> solve(String str) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean find = false;

        queue.add(str);
        visited.add(str);

        while(!queue.isEmpty()){
            for(int j=0; j<queue.size(); j++) {
                String subStr = queue.poll();

                if (check(subStr)) {
                    find=true;
                    result.add(subStr);
                    System.out.println(subStr);
                }
                if(find==true){
                    continue;
                }
                for (int i = 0; i < subStr.length(); i++) {
                    if(subStr.charAt(i)!='('&&subStr.charAt(i)!=')'){
                        continue;
                    }
                    String newStr = subStr.substring(0, i) + "" + subStr.substring(i + 1);
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        queue.add(newStr);
                    }
                }
            }
        }
        return result;
    }

    private boolean check(String subStr) {
        int count = 0;
        for(int i=0; i<subStr.length(); i++){
            String s = ""+subStr.charAt(i);
            if(s.equals("(")){
                count++;
            }
            else if(s.equals(")")){
                count--;
                if(count<0){
                    return false;
                }
            }
            else{
                continue;
            }
        }
        if(count==0){
            return true;
        }
        return false;
    }
}
