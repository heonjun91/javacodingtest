package Programmers.LevelOne;

import java.util.Arrays;

//[카카오] 비밀지도
public class SecretMap {
    public static void main(String[] args){
        int n=6;
        int[] arr1={46, 33, 33 ,22, 31, 50};
        int[] arr2={27 ,56, 19, 14, 14, 10};
        
        SecretMap sm = new SecretMap();
        System.out.println(Arrays.toString(sm.solve(n,arr1,arr2)));
    }

    public String[] solve(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0; i<arr1.length; i++){
            String s = Integer.toBinaryString(arr1[i]|arr2[i]);
            while(s.length()!=n){
                s = "0"+s;
            }

            System.out.println(s);
            s = s.replace('1','#');
            s = s.replace('0',' ');
            answer[i] = s;

        }
        return answer;
    }
}
