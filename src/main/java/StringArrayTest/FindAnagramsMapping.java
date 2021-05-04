package StringArrayTest;

import java.util.Arrays;
import java.util.HashMap;

//A와 B의 리스트가 2개가 주어졌고, B는 A의 다이어그램이다.
// B는 A의 도표로, B는 A의 원소의 순서를 랜덤화하여 만든다는 것을 의미합니다.
//우리는 A에서 B까지 인덱스 맵핑 P를 찾고 싶습니다.
// 매핑 P[i] = j는 A의 ith 요소가 Bat 색인 j에 나타난다는 것을 의미합니다.
//이 목록 A와 B에는 중복 항목이 포함될 수 있습니다. 답이 여러 개일 경우 아무 대답이나 출력합니다.
//예를 들어
//A = [12, 28, 46, 32, 50]
//B = [50, 12, 32, 46, 28]
//[1, 4, 3, 2, 0]
public class FindAnagramsMapping {

    public static void main(String[] args) {
        int[] A = {12,28,46,32,50};
        int[] B = {50,12,32,46,28};

        FindAnagramsMapping fam = new FindAnagramsMapping();
        fam.solve(A,B);
    }

    public void solve(int[] a, int[] b) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] result = new int[a.length];

        for(int i=0; i<b.length; i++){
            hm.put(b[i],i);
        }

        for(int i=0; i<a.length; i++){
            result[i] = hm.get(a[i]);
        }

        System.out.println(Arrays.toString(result));
    }
}
