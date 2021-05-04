package Programmers.LevelOne;
//3진법 뒤집기

public class FlipTheTrilogy {
    public static void main(String[] args){
        int n = 125;

        FlipTheTrilogy ftt = new FlipTheTrilogy();
        System.out.println(ftt.solve(n));
    }

    public int solve(int n) {
        int answer = 0;
        String s = "";

        while(n!=0){
            s += ""+n%3;
            n = n/3;
        }
        for(int i=s.length()-1; i>=0; i--){
            int num = Integer.parseInt(""+s.charAt(i));

            answer += num*Math.pow(3,s.length()-1-i);
        }

        return answer;
    }
}
