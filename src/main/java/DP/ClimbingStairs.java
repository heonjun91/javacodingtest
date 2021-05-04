package DP;
//당신은 계단을 오르고 있습니다.
//꼭대기에 도착하려면 n개의 계단을 올라야 합니다.
//한 번에 1개 혹은 2개의 계단씩 오를 수 있습니다.
//꼭대기까지 올라갈 수 있는 방법은 총 몇 가지일까요?
//단, n은 양의 정수입니다.
//
//- 예시 1:
//    입력: 2
//    출력: 2
//    1. 1계단 + 1계단
//    2. 2계단
//
//- 예시 2:
//    입력: 3
//    출력: 3
//    설명: 3개의 계단을 올라야 꼭대기에 도착하는 경우, 총 3가지 방법으로 오를 수 있습니다.
//    1. 1계단 + 1계단 + 1계단
//    2. 1계단 + 2계단
//    3. 2계단 + 1계단
public class ClimbingStairs {

    public static void main(String[] args){
        int stairs = 45;

        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.solve(stairs));
        System.out.println(cs.solve2(stairs));

    }

    public int solve(int stairs) {
        if(stairs==2)
            return 2;
        if(stairs==1)
            return 1;

        return solve(stairs-1)+solve(stairs-2);
    }
    public int solve2(int stairs) {
        int[] DP = new int[stairs+1];

        DP[1] = 1;
        if(stairs>1)
            DP[2] = 2;
        if(stairs>2){
            for(int i=3; i< DP.length; i++){
                DP[i] = DP[i-1]+DP[i-2];
            }
        }
        return DP[stairs];
    }
}
