package Programmers.LevelTwo;
//124 나라
public class Country124 {
    public static void main(String[] args) {

        Country124 c = new Country124();
        System.out.println(c.solution(500000000));


    }

    public String solution(int n) {
        StringBuffer answer = new StringBuffer();

        String[] arr = new String[n];

        answer.append(dp(arr,n-1)) ;
        return answer.toString();
    }

    public String dp(String[] arr, int n){
        if(n==0){
            return "1";
        }
        if(n==1){
            return "2";
        }
        if(n==2){
            return "4";
        }

        return dp(arr,n/3-1)+dp(arr,n%3);
    }




}
