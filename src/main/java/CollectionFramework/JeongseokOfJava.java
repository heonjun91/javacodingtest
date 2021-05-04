package CollectionFramework;


public class JeongseokOfJava {
    /*
       Collection : 여러객체(데이터)를 모아 놓은 것
       Framework : 표준화, 정형화된 체계적인 프로그래밍 방식
       Collection Framework : 컬렉션(다수의객체)을 다루기위한 표준화된 프로그래밍 방식
                              컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스 제공
                              (저장,삭제,검색,정렬)
                              java.util 패키지에 포함
       Collection class : 다수의 데이터를 저장할수 있는 클래스
                          (Vector, ArrayList, HashSet)

       핵심 인터페이스
       List : 순서가 있는 데이터 집합 , 중복 허용
              ArrayList, LinkedList, Stack, Vector 등

       Set : 순서 x, 중복 x
             HashSet, TreeSet 등

       Map : key 와 value 의 쌍으로 이루어진 데이터 집합, 순서 X
             key : 중복 x (ID)
             value : 중복 o (PASSWORD)
             HashMap, TreeMap, Hashtable, Properties 등

       Collection 인터페이스: List , Set 의 조상


       Iterator(단방향), ListIterator(양방향), Enumeration(old version)
       - 컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스
       - boolean hasNext() : 읽어올 요소가 남아있는지 확인. 있으면 true, 없으면 false
       - Object next() : 다음 요소를 읽어옴
       - Map 에는 iterator가 없다. (Collection의 자손이 아님) -> keySet(), entrySet(), values()를 이용


       Comparator(기본 정렬 기준 외 다른 기준) 와 Comparable(기본 정렬 기준)
       - 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스

       Comparator -> compare() , Comparable -> compareTo()
       - 두 객체의 비교결과 반환 ( 오른쪽이 크면 음수, 같으면 0 , 오른쪽이 작으면 양수 )


       HashSet
       - Set 인터페이스를 구현한 대표적인 컬렉션 클래스
       - 순서를 유지하려면 LinkedHashSet 클래스 사용

       TreeSet
       - 범위 검색과 정렬에 유리한 컬렉션 클래스(ceiling, floor)
       - 정렬되서 저장
       - HashSet 보다 데이터 추가, 삭제에 시간이 더 걸림

     */



}
