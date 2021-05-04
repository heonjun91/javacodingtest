package Programmers.LevelOne;
//문자열을 정수로 바꾸기
public class ChangeStringToInteger {
    public static void main(String[] args) {
        String s = "-1234";
        ChangeStringToInteger csti = new ChangeStringToInteger();
        System.out.println(csti.solve(s));
    }

    public int solve(String s) {
        int answer = 0;
        answer = Integer.parseInt(s);
        return answer;
    }
}
