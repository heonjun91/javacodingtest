package StringArrayTest;

import javax.swing.text.StyledEditorKit;
import java.util.Arrays;

//문자열과 비어 있지 않은 문자열 p가 주어지면 p의 모든 시작 인덱스를 s에서 찾습니다.
///문자열은 영문 소문자로만 구성되며 문자열과 p의 길이는 20,100보다 크지 않습니다.
//출력 순서는 중요하지 않다.
public class FindAllAnagrams {

    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        FindAllAnagrams fa = new FindAllAnagrams();
        fa.solve(txt,pat);
    }

    public void solve(String txt, String pat) {

        int[] patArr = new int[256];
        for(int i=0; i<pat.length(); i++){
            patArr[pat.charAt(i)]+=1;
        }

        for(int i=0; i<txt.length()-pat.length()+1; i++){
            int[] txtArr = new int[256];

            for(int j=i; j<i+pat.length(); j++){
                //System.out.println(txt.charAt(j));
                txtArr[txt.charAt(j)]+=1;
            }

            boolean result = true;
            for(int k=0; k<256; k++){
                if(txtArr[k]!=patArr[k]){
                    result= false;
                    break;
                }
            }
            if(result==true){
                System.out.println(i);
            }
        }

    }
}
