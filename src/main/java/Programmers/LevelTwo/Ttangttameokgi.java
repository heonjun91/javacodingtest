package Programmers.LevelTwo;
//땅따먹기
public class Ttangttameokgi {

    public static void main(String[] args){
        int[][] land ={{9, 5, 2, 3},{9, 8, 6, 7},{8, 9, 7, 1},{100, 9, 8, 1}};
                //{{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        Ttangttameokgi t = new Ttangttameokgi();
        System.out.println(t.solution(land));
    }

    public int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                int max = 0;
                for(int k=0; k<4; k++){
                    if(j==k)
                        continue;
                    if(dp[i-1][k]>max){
                        max = dp[i-1][k];
                    }
                }
                dp[i][j] = land[i][j]+max;
            }
            if(i==land.length-1){
                for(int j=0; j<4; j++){
                    if(answer<dp[i][j])
                        answer = dp[i][j];
                }
            }
        }

        return answer;
    }

}
