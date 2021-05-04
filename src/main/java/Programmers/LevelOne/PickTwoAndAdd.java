package Programmers.LevelOne;

import java.util.*;

//두 개 뽑아서 더하기
//정수 배열 numbers가 주어집니다.
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
// 만들 수 있는 모든 수를 배열에 오름차순으로 담아
// return 하도록 solution 함수를 완성해주세요.
//numbers의 길이는 2 이상 100 이하입니다.
//numbers의 모든 수는 0 이상 100 이하입니다.
//numbers	    result
//[2,1,3,4,1]	[2,3,4,5,6,7]
//[5,0,2,7]	    [2,5,7,9,12]
public class PickTwoAndAdd {

    public static void main(String[] args){
        int[] numbers = {0,100,1000,10};

        PickTwoAndAdd pta = new PickTwoAndAdd();
        System.out.println(Arrays.toString(pta.solve(numbers)));
    }

    public int[] solve(int[] numbers) {
        int[] answer ={};
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[set.size()];

        Iterator it = set.iterator();
        int i=0;
        while(it.hasNext()){
            answer[i] = (int)it.next();
            i++;
        }

        Arrays.sort(answer);


        return answer;
    }
}
