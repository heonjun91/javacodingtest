package StringArrayTest;
//일별 온도 T 리스트가 주어지면 각각에 대해 다음과 같은 리스트를 반환합니다.
//입력에서 day, 더 따뜻해질 때까지 얼마나 기다려야 하는지 알려줍니다.
//만약 미래의 날이 없다면 가능합니다. 대신 0을 넣으십시오.
//예를 들어, 주어진 온도 리스트
//T = [73, 74, 75, 71, 69, 72, 76, 73],
//출력은 [1, 1, 4, 2, 1, 1, 0, 0]이어야 합니다.


public class DailyTemperature {

    public void solve(int[] temp){
        for(int i=0; i<temp.length; i++){
            boolean result = false;
            for(int j=i+1; j<temp.length; j++){
                if(temp[i]<temp[j]){
                    System.out.println(j-i);
                    result = true;
                    break;
                }
            }
            if(result==false){
                System.out.println(0);
            }

        }
    }
    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] T = {73,74,75,71,69,72,76,73};

        dt.solve(T);
    }
}
