package StringArrayTest;
//보석인 돌을 나타내는 문자열 J 를 입력받고, 본인이 갖고 있는 돌을 나타내는 문자열 S 를 입력받는다.
// S 의 각 문자는 본인이 가진 돌의 타입이다.
// 갖고 있는 돌 중에 몇개나 보석인지 알아보고 싶다. 문자열 J 는 다 구별되어있고,
// J 와 S 는 문자들이다. 문자들은 각각 A, a 대소문자 구별된다.


import java.util.HashSet;
import java.util.Iterator;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones js = new JewelsAndStones();

        String jewels = "aA";
        String stones = "aAAbbbb";

        js.solve(jewels,stones);
    }

    public void solve(String jewels, String stones) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<jewels.length(); i++){
            hs.add(jewels.charAt(i));
        }
//        Iterator it = hs.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        int result = 0;
        for(int i=0; i<stones.length(); i++){
            if(hs.contains(stones.charAt(i))){
                result++;
            }
        }
        System.out.println(result);
    }
}
