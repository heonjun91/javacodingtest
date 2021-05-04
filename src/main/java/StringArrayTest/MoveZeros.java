package StringArrayTest;
//배열 num을 감안할 때 0이 아닌 요소의 상대적인 순서를 유지하면서
//모든 0을 끝으로 이동시키는 함수 작성

public class MoveZeros {
    public int[] solve(int[] nums){
        int arr[] = new int[nums.length];
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                arr[j]=nums[i];
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();

        int[] nums={0,3,2,0,8,5};

        for(int i:mz.solve(nums)){
            System.out.println(i);
        }
    }
}
