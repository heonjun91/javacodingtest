package StringArrayTest;

//input으로 여러개의 이메일 주소가 주어지는데 실제로 전달받는 메일은 몇개인가?
// 단, 아래 규칙을 따른다.1) '@'를 기준으로 앞에는 Local Name,
// 뒤는 Domain Name이다.2) Local Name에 '.' 있으면 무시한다.
// ex) d.e@naver.com == de@naver.com3) Local Name에 '+' 이 시작하는 부분부터 신경쓰지 않는다.
// ex) d.e+23@naver.com = de@naver.com

import java.util.HashSet;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress uea = new UniqueEmailAddress();

        String[] emails = { "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com",
                "bcgrhji.dl@naver.com",
                "bcg+rhji.dl@naver.com",
                "bcgrhji.asddl@naver.com"
        };

        uea.solve(emails);
    }

    public void solve(String[] emails) {
        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<emails.length; i++){
            String s = emails[i];
            int indexPlus = s.indexOf("+");
            int indexGolbang = s.indexOf("@");
            if(s.contains("+")){
                String temp = s.substring(indexPlus,indexGolbang);
                s = s.replace(temp,"");
            }
            String localName = s.substring(0,indexGolbang);
            String domainName = s.substring(indexGolbang);

            localName = localName.replace(".","");

            String result = localName.concat(domainName);

            hs.add(result);
            //System.out.println(result);
        }
        System.out.println(hs.size());
    }
}
