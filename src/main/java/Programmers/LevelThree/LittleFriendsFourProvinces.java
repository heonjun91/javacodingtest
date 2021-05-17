package Programmers.LevelThree;

public class LittleFriendsFourProvinces {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        String[] board = {"DBA","C*A","CDB"};
        LittleFriendsFourProvinces lffp = new LittleFriendsFourProvinces();
        System.out.println(lffp.solution(m,n,board));
    }

    public String solution(int m, int n, String[] board) {
        String answer = "";



        return answer;
    }

    public boolean isPossible(int m, int n, char[][] map){
        boolean ispossible = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]!='*'&&map[i][j]!='.'){
                    dfs(i,j,map[i][j]);
                }
            }
        }

        return ispossible;
    }

    public void dfs(int x, int y, char c){

    }
}
