package Programmers.LevelOne;
//문자열 기초
public class StringBasic {
    public static void main(String[] args) {
        String s = "-1234";
        StringBasic sb = new StringBasic();
        System.out.println(sb.solve(s));

    }

    public boolean solve(String s) {
        boolean answer = true;

        if(s.length()!=4||s.length()!=6)
            answer = false;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            System.out.println(c-'0');
            if(c-'0'<0||c-'0'>9)
                answer= false;
        }
        return answer;
    }
}
