package Programmers.LevelOne;
//서울에서 김서방 찾기
public class FindKimInSeoul {
    public static void main(String[] args) {
        String[] seoul = {"Jane","Kim"};
        FindKimInSeoul fkis = new FindKimInSeoul();
        System.out.println(fkis.solve(seoul));
    }

    public String solve(String[] seoul) {
        String answer = "";
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer+="김서방은 "+i+"에 있다";
                break;
            }
        }
        return answer;
    }
}
