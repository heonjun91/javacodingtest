package DFSandBFS;

//시작 문자 : hit
//끝 문자 : cog
//문자 리스트 : hot, dot, dog, lot,log, cog
//다음과 같이 parameter가 제공되고 시작 문자에서 한글자씩만 바꿔서
// 문자리스트에 있는 문자들을 통해 끝문자인 cog로 변경되는데까지의 횟수를 구하시오.
//예를 들어, hit ->(ait..zit , hat..hzt , hia..hiz)
// -> hot -> dot -> dog -> log -> cog.    => 총 5회.



import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

    class object{
        String word;
        int dis;

        object(String word, int dis){
            this.word = word;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        //String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String[] wordList = {"hot","dot","dog","lot","log"};

        WordLadder wl = new WordLadder();
        wl.solve(beginWord,endWord,wordList);
    }

    public void solve(String beginWord, String endWord, String[] wordList) {
        Queue<object> queue = new LinkedList<>();
        object obj = new object(beginWord,1);

        queue.offer(obj); //hit 추가 dis=1

        while(!queue.isEmpty()) {
            object s = queue.poll();

            for(int i=0; i<wordList.length; i++){
                if(wordList[i]=="x"){
                    continue;
                }
                if(!comp(s.word,wordList[i]))
                    continue;

                if(endWord.equals(wordList[i])){
                    System.out.println(s.dis+1);
                    return;
                }
                queue.offer(new object(wordList[i],s.dis+1));
                wordList[i] = "x";
            }
        }
        System.out.println(0);
    }

    public boolean comp(String a,String b){
        int cnt = 0;

        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            char d = b.charAt(i);
            if(c==d)
                cnt++;
        }
        if(cnt==2)
            return true;
        else
            return false;
    }

}
