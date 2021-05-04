package StringArrayTest;
//주어진 배열을 하나의 숫자로 생각하고 1 을 더한 결과 배열을 리턴하면 됩니다.

//[1, 2, 3] 은 123 으로 생각하고 1 을 더한 [1, 2, 4] 배열을 리턴합니다.

//[9, 9] 는 100 이 되기 때문에 [1, 0, 0] 을 리턴해야 하고 배열로 [0, 0] 이 주어지기도 합니다.


import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne po = new PlusOne();

        int[] digits = {8,9,9};

        po.solve(digits);
    }

    public void solve(int[] digits) {
        int index = digits.length-1;

        while(index>=0){
            if(digits[index]+1 <10){
                digits[index]++;
                System.out.println(Arrays.toString(digits));
                return;
            }
            else{
                digits[index]=0;
                index--;
            }
        }

        int[] newdigits = new int[digits.length+1];
        newdigits[0] = 1;
        System.out.println(Arrays.toString(newdigits));
    }
}
