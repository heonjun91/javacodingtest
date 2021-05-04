package Programmers.LevelTwo;

public class TargetNumber {
    int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(numbers,target));
    }

    public int solution(int[] numbers, int target) {

        dfs(numbers,target,0,0);

        return answer;
    }

    public void dfs(int[] numbers, int target, int n,int sum) {
        if(n==numbers.length){
            if(sum==target){
                answer++;
                return;
            }
        }
        else{
            dfs(numbers,target,n+1,sum+numbers[n]);
            dfs(numbers,target,n+1,sum-numbers[n]);
        }

    }
}
