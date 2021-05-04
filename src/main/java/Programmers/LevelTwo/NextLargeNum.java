package Programmers.LevelTwo;

public class NextLargeNum {
    public static void main(String[] args){
        int n= 1000000;

        NextLargeNum nln = new NextLargeNum();
        System.out.println(nln.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        int bitCount = Integer.bitCount(n);

        while(true){
            n++;
            if(Integer.bitCount(n)==bitCount)
                break;
        }
        answer = n;

        return answer;
    }
}
