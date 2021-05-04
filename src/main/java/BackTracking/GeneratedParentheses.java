package BackTracking;
//음이 아닌 정수 n이 주어질 때, 모든 '(' 와 ')' 로 이루어진 유효한 조합들을 찾아라.
//n= 3일 때는
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GeneratedParentheses {

    public static void main(String[] args) {
        int n = 3;

        GeneratedParentheses gp = new GeneratedParentheses();
        System.out.println(gp.solve(n));
    }

    public List<String> solve(int n) {
        List<String> result = new ArrayList<>();
        dfs(n,"",0,0,result );

        return result;
    }

    public void dfs(int n, String str,int left, int right, List<String> result) {

        if (left < right) {
            return;
        }
        if (left > n)
            return;

        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        dfs(n, str + "(", left + 1, right, result);
        dfs(n, str + ")", left, right + 1, result);
    }
}
