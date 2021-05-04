package String;

public class JeongseokOfJava {
    public static void main(String[] args) {
        //1. String 클래스(객체)
        //String 클래스 = 데이터(char[])+ 메서드(문자열관련)
        //내용을 변경할 수 없는 불변 클래스
        String a = "a"; // a(0x100) -> "a"
        String b = "b"; // b(0x200) -> "b"

        a = a+b;	// a(0x300) -> "ab"
        //-덧셈 연산자(+) 를 이용한 문자열 결합은 성능이 떨어짐.
        //따라서 문자열의 결합이나 변경이 잦다면, StringBuffer를 사용함!!


        //2. 문자열비교
        String str1 = "abc";
        String str2 = "abc"; // 같은 0x100주소의 "abc"를 가르킴 ("abc" 공유)

        String str3 = new String("abc"); //0x200주소의 "abc" 가르킴
        String str4 = new String("abc"); //0x300주소의 "abc" 가르킴 //주소 다름

        System.out.println(str1==str2); //str1= 0x200 // True
        System.out.println(str3==str4); //str2= 0x300 // False

        // equals : 내용비교
        System.out.println(str1.equals(str2)); //TRUE
        System.out.println(str3.equals(str4)); //TRUE



        //3. 문자열 리터럴
        //프로그램 실행시 자동으로 생성된다!(자동으로 new String("abc"))
        //constant pool(상수 저장소)에 저장
        //같은 내용의 문자열 리터럴은 하나만 만들어진다.
        String str5 = "dcf";


        //4. String 클래스의 생성자와 메서드
        String s = new String("one");

        //지정된 index에 있는 문자 반환
        String s2 = "Hello";
        System.out.println("3번째글자 : "+s2.charAt(2));

        //사전순서로 문자열 비교
        String s3 = "aaa";
        String s4 = "bbb";
        System.out.println("같으면 0, 사전순 더빠르면 음수 "+s3.compareTo(s4));

        //문자열 뒤에 덧붙임
        String s5 = "hello";
        System.out.println(s5.concat(" world"));

        //지정된 문자열이 포함되어있는지 검사
        String s7 = "abc";
        System.out.println(s7.contains("ab")); //맞으면 트루

        //지정된 문자열로 끝나는지 검사 , 시작하는지 검사
        String s8 = "abcdef";
        System.out.println(s8.endsWith("ef")); //True
        System.out.println(s8.startsWith("ef")); //False

        //문자열 비교 , 대소문자 구분 없이 비교
        String s9 = "abcd";
        System.out.println(s9.equals("ABCD")); //False
        System.out.println(s9.equalsIgnoreCase("ABCD")); //True

        //주어진 문자의 index 반환 (없으면 -1)
        String s10 = "abcd";
        System.out.println(s10.indexOf("b")); //1
        System.out.println(s10.indexOf("b",2));//-1반환 (찾기시작하는위치)

        //문자열을 지정된 분리자로 나누어 문자열 배열에 담아 반환
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        System.out.println(arr[0]+" "+arr[1]);

        String[] arr2 = animals.split(",",2); //2번으로 나눔
        System.out.println(arr2[0]+" "+arr2[1]);


        //시작위치부터 끝위치에 포함된 문자열 반환
        //begin 이상  end 미만
        String s11 = "abcde";
        System.out.println(s11.substring(2,5)); //index 2 부터 4까지


        ///5. join()과 StringJoiner

        //join() : 여러문자열사이에 구분자를 넣어서 결함
        String animalsJoin = String.join("-",arr);
        System.out.println(animalsJoin);

        //기본형을 문자열로 바꾸는방법
        int i = 100;
        String valuof = String.valueOf(i);
        System.out.println(valuof);


        /////6. StringBuffer 클래스
        //String 과 달리 내용을 변경할 수 있다.
        //equals()로 비교 불가-> string으로 바꿔서 비교
        //멀티쓰레드에 좋음

        //내용뒤에 문자열을 추가
        StringBuffer appendStr = new StringBuffer("hello");
        appendStr.append(" world");
        System.out.println(appendStr);

        //문자열로 변환
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb1 = new StringBuffer("abc");

        String s14 = sb.toString();
        String s15 = sb1.toString();
        System.out.println(s14.equals(s15)); //true


    }
}
