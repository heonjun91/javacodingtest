package Programmers.LevelOne;
//가운데 글자 가져오기
public class ImportCenterLetter {
    public static void main(String[] args){
        String s = "abcdef";

        ImportCenterLetter icl = new ImportCenterLetter();
        icl.solve(s);
    }

    public String solve(String s) {
        while(s.length()>2){
            s = s.substring(1,s.length()-1);
            System.out.println(s);
        }
        return s;
    }
}
