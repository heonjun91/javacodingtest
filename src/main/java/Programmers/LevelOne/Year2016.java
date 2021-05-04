package Programmers.LevelOne;

public class Year2016 {

    public static void main(String[] args){
        int a = 5;
        int b = 24;

        Year2016 y = new Year2016();
        System.out.println(y.solve(a,b));
    }

    public String solve(int a, int b) {
        String answer = "";

        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] monthday = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int totalDay =0;
        for(int i=1; i<a; i++){
            totalDay+=monthday[i];
        }
        totalDay+=b;

        answer = day[(totalDay-1)%7];

        return answer;

    }
}
